package joint_budget.joint_budget.API;

import java.util.LinkedList;

import joint_budget.joint_budget.DataTypes.Event;
import joint_budget.joint_budget.DataTypes.Purchase;


public abstract class EventsAPI {

    public EventsAPI() {
    }


    public boolean createEvent(Event event) {
        // TODO implement me
        return false;
    }


    public boolean deleteEvent(String eventID) {
        // TODO implement me
        return false;

    }


    public boolean updateEvent(Event event) {
        // TODO implement me
        return false;

    }


    public boolean addPurchase(Purchase purchase) {
        // TODO implement me
        return false;

    }


    public boolean editPurchase(Purchase purchase) {
        // TODO implement me
        return false;

    }


    public boolean deletePurchase(String eventID, String purchaseID) {
        // TODO implement me
        return false;

    }


    public boolean joinEvent(String EventID, String Password) {
        // TODO implement me
        return false;

    }


    public LinkedList<Event> getAllEvents() {
        // TODO implement me
        return new LinkedList<>();

    }


    public LinkedList<Purchase> getAllPurchases() {
        // TODO implement me
        return new LinkedList<>();
    }


    public void subscribeToEventsUpdates() {
        // TODO implement me
    }


    public void subscribeToPurchasesUpdates() {
        // TODO implement me
    }

}

