package joint_budget.joint_budget.API;

import java.util.LinkedList;

import joint_budget.joint_budget.DataTypes.EventPage;
import joint_budget.joint_budget.DataTypes.PurchasePage;


public abstract class EventsAPI {

    public EventsAPI() {
    }


    public boolean createEvent(EventPage eventPage) {
        // TODO implement me
        return false;
    }


    public boolean deleteEvent(String eventID) {
        // TODO implement me
        return false;

    }


    public boolean updateEvent(EventPage eventPage) {
        // TODO implement me
        return false;

    }


    public boolean addPurchase(PurchasePage purchasePage) {
        // TODO implement me
        return false;

    }


    public boolean editPurchase(PurchasePage purchasePage) {
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


    public LinkedList<EventPage> getAllEvents() {
        // TODO implement me
        return new LinkedList<>();

    }


    public LinkedList<PurchasePage> getAllPurchases() {
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

