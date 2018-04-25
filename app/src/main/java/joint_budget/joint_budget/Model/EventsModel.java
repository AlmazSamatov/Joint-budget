package joint_budget.joint_budget.Model;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import joint_budget.joint_budget.API.EventsAPI;
import joint_budget.joint_budget.API.FIrebaseAPI.FirebaseEventsAPI;
import joint_budget.joint_budget.DataTypes.Event;
import joint_budget.joint_budget.DataTypes.Purchase;

public class EventsModel {

    private List<Event> events;
    private List<Purchase> purchases;
    private EventsAPI eventsAPI;

    private static volatile EventsModel instance;

    public static EventsModel getInstance() {
        EventsModel localInstance = instance;
        if (localInstance == null) {
            synchronized (EventsModel.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new EventsModel();
                }
            }
        }
        return localInstance;
    }

    private EventsModel() {
        events = new ArrayList<>();
        purchases = new ArrayList<>();
        eventsAPI = new FirebaseEventsAPI();
    }

    public void addEvent(Event event) {
        events.add(event);
        /*try {
            eventsAPI.createEvent(event);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        addEventToDB(event);
    }

    private void addEventToDB(Event event) {
        try (Realm realm = Realm.getDefaultInstance()) {
            realm.beginTransaction();
            Event eventToAdd = realm.createObject(Event.class);
            eventToAdd.setName(event.getName());
            eventToAdd.setEventId(event.getEventId());
            eventToAdd.setPassword(event.getPassword());
            eventToAdd.setStartDate(event.getStartDate());
            eventToAdd.setEndDate(event.getEndDate());
            eventToAdd.setCurrency(event.getCurrency());
            eventToAdd.setParticipants(event.getParticipants());
            eventToAdd.setShopList(event.getShopList());
            eventToAdd.setPurchases(event.getPurchases());
            eventToAdd.setDebts(event.getDebts());
            realm.commitTransaction();
        }
    }

    public void deleteEventFromDB(Event event){
        try (Realm realm = Realm.getDefaultInstance()) {
            realm.beginTransaction();
            RealmResults<Event> eventToDelete = realm.where(Event.class).equalTo("name", event.getName()).findAll();
            if (!eventToDelete.isEmpty()) {
                eventToDelete.get(0).deleteFromRealm();
            }
            realm.commitTransaction();
        }

    }

    public void getEventsFromDB(LoadEventsFromDBCallback callback) {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Event> events = realm.where(Event.class).findAll();
        callback.onLoad(events);
    }

    public void updateEvent(Event oldEvent, Event newEvent) {

        updateEventInDB(oldEvent, newEvent);
    }

    public void updateEventInDB(Event oldEvent, Event newEvent){
        try (Realm realm = Realm.getDefaultInstance()) {
            realm.beginTransaction();
            Event eventInDB = realm.where(Event.class).equalTo("name", oldEvent.getName()).findFirst();
            eventInDB.setName(newEvent.getName());
            eventInDB.setEventId(newEvent.getEventId());
            eventInDB.setPassword(newEvent.getPassword());
            eventInDB.setStartDate(newEvent.getStartDate());
            eventInDB.setEndDate(newEvent.getEndDate());
            eventInDB.setCurrency(newEvent.getCurrency());
            eventInDB.setParticipants(newEvent.getParticipants());
            eventInDB.setShopList(newEvent.getShopList());
            eventInDB.setPurchases(newEvent.getPurchases());
            eventInDB.setDebts(newEvent.getDebts());
            realm.commitTransaction();
        }
    }

    /*public void getEvents(EventsAPI.LoadEventsCallback callback) {
        try {
            eventsAPI.getAllEvents(callback);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

    public void deleteEvent(String eventID) {
        try {
            eventsAPI.deleteEvent(eventID);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void editEvent(Event event){
        try {
            eventsAPI.updateEvent(event);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void joinEvent(String eventID, String password, EventsAPI.LoadEventsCallback callback){
        eventsAPI.joinEvent(eventID, password, callback);
    }

    public interface LoadEventsFromDBCallback{
        void onLoad(List<Event> events);
    }

    public interface LoadPurchasesFromDBCallback {
        void onLoad(List<Purchase> purchases);
    }

    public List<Purchase> getPurchases(String eventID){
        return new ArrayList<>();
    }

    public Purchase getPurchase(String eventID, String purchaseID){
        return new Purchase();
    }

    void savePurchase(Purchase purchase){ }

    void updatePurchase(Purchase purchase){}

    void deletePurchase(String eventID, String purchaseID){}
}
