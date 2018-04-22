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
    private final String eventsDBName = "Events";
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
            eventToAdd.setCurrency(event.getCurrency());
            eventToAdd.setEndDate(event.getEndDate());
            eventToAdd.setStartDate(event.getStartDate());
            eventToAdd.setEventId(event.getEventId());
            eventToAdd.setName(event.getName());
            eventToAdd.setParticipants(event.getParticipants());
            eventToAdd.setPassword(event.getPassword());
            eventToAdd.setShopList(event.getShopList());
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

    public void updateEventInDB(Event oldEvent, Event newEvent){
        try (Realm realm = Realm.getDefaultInstance()) {
            realm.beginTransaction();
            Event eventInDB = realm.where(Event.class).equalTo("name", oldEvent.getName()).findFirst();
            eventInDB.setCurrency(newEvent.getCurrency());
            eventInDB.setEndDate(newEvent.getEndDate());
            eventInDB.setStartDate(newEvent.getStartDate());
            eventInDB.setEventId(newEvent.getEventId());
            eventInDB.setName(newEvent.getName());
            eventInDB.setParticipants(newEvent.getParticipants());
            eventInDB.setPassword(newEvent.getPassword());
            eventInDB.setShopList(newEvent.getShopList());
            realm.commitTransaction();
        }
    }

    private void addPurchasesToDB(Purchase purchase) {
        try (Realm realm = Realm.getDefaultInstance()) {
            realm.beginTransaction();
            Purchase purchaseToAdd = realm.createObject(Purchase.class);
            purchaseToAdd.setPurchaseItems(purchase.getPurchaseItems());
            purchaseToAdd.setCurrency(purchase.getCurrency());
            purchaseToAdd.setTotalCost(purchase.getTotalCost());
            purchaseToAdd.setPurchaseName(purchase.getPurchaseName());
            purchaseToAdd.setPurchaseID(purchase.getPurchaseID());
            purchaseToAdd.setEventID(purchase.getEventID());
            realm.commitTransaction();
        }
    }

    public void deletePurchaseFromDB(Purchase purchase){
        try (Realm realm = Realm.getDefaultInstance()) {
            realm.beginTransaction();
            RealmResults<Purchase> purchasesToDelete = realm.where(Purchase.class).equalTo("purchaseName", purchase.getPurchaseName()).findAll();
            if (!purchasesToDelete.isEmpty()) {
                purchasesToDelete.get(0).deleteFromRealm();
            }
            realm.commitTransaction();
        }
    }

    public void getPurchasesFromDB(LoadPurchasesFromDBCallback callback, String eventName) {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Purchase> purchases = realm.where(Purchase.class).equalTo("eventName", eventName).findAll();
        callback.onLoad(purchases);
    }

    public void updatePurchaseInDB(Purchase oldPurchase, Purchase newPurchase){
        try (Realm realm = Realm.getDefaultInstance()) {
            realm.beginTransaction();
            Purchase purchaseInDB = realm.where(Purchase.class).equalTo("purchaseName", oldPurchase.getPurchaseName()).findFirst();
            purchaseInDB.setPurchaseItems(newPurchase.getPurchaseItems());
            purchaseInDB.setCurrency(newPurchase.getCurrency());
            purchaseInDB.setTotalCost(newPurchase.getTotalCost());
            purchaseInDB.setPurchaseName(newPurchase.getPurchaseName());
            purchaseInDB.setPurchaseID(newPurchase.getPurchaseID());
            purchaseInDB.setEventID(newPurchase.getEventID());
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

    public void joinEvent(String eventID, String password){
        eventsAPI.joinEvent(eventID, password);
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
