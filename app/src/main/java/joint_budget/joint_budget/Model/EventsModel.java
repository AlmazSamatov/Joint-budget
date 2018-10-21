package joint_budget.joint_budget.Model;

import java.util.ArrayList;
import java.util.List;

import joint_budget.joint_budget.API.EventsAPI;
import joint_budget.joint_budget.API.FIrebaseAPI.FirebaseEventsAPI;
import joint_budget.joint_budget.DataTypes.Event;
import joint_budget.joint_budget.DataTypes.Purchase;

public class EventsModel {

    private List<Event> events;
    private EventsAPI eventsAPI;

    private List<Purchase> purchases;

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

    public Event addEvent(Event event) {
        try {
            return eventsAPI.createEvent(event);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Event();
    }

    public void updateEvent(Event newEvent) {
        try {
            eventsAPI.updateEvent(newEvent);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getEvents(String userID, EventsAPI.LoadEventsCallback callback) {
        try {
            eventsAPI.getAllEvents(callback, userID);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void deleteEvent(String eventID) {
        try {
            deleteEventFromLocal(eventID);
            eventsAPI.deleteEvent(eventID);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void deleteEventFromLocal(String eventID) {
        for(int i = 0; i < events.size(); i++){
            if(events.get(i).getEventId().equals(eventID)){
                events.remove(i);
                break;
            }
        }
    }

    public void editEvent(Event event){
        try {
            eventsAPI.updateEvent(event);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void joinEvent(String eventID, String password, EventsAPI.LoadEventsCallback callback,
                          String userID){
        eventsAPI.joinEvent(eventID, password, callback, userID);
    }

    public void addPurchase(Purchase purchase) {
        eventsAPI.addPurchase(purchase);
        purchases.add(purchase);
    }

    public void getPurchases(EventsAPI.LoadPurchasesCallback callback, String eventID){
        eventsAPI.getAllPurchases(callback, eventID);
    }

    public void updatePurchase(Purchase purchase){
        DebtsModel.getInstance().updateDebts(purchase);
        for (int i = 0; i < purchases.size(); i++) {
            if (purchases.get(i).getPurchaseID().equals(purchase.getPurchaseID())) {
                purchases.set(i, purchase);
                break;
            }
        }
        eventsAPI.updatePurchase(purchase);
    }

    public void deletePurchase(String eventID, String purchaseID){
        for (int i = 0; i < purchases.size(); i++) {
            if (purchases.get(i).getPurchaseID().equals(purchaseID)) {
                DebtsModel.getInstance().deleteDebts(purchases.get(i));
                purchases.remove(i);
                break;
            }
        }
        eventsAPI.deletePurchase(eventID, purchaseID);
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Event> getEventsLocal() {
        return events;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }
}
