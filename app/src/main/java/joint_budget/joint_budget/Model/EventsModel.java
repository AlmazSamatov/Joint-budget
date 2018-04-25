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
        try {
            eventsAPI.createEvent(event);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void updateEvent(Event oldEvent, Event newEvent) {

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
