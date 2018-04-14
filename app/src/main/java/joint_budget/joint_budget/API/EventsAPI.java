package joint_budget.joint_budget.API;

import java.util.LinkedList;
import java.util.List;

import joint_budget.joint_budget.DataTypes.Event;
import joint_budget.joint_budget.DataTypes.Purchase;


public interface EventsAPI {


    Event createEvent(Event event) throws InterruptedException;


    boolean deleteEvent(String eventID) throws InterruptedException;


    boolean updateEvent(Event event) throws InterruptedException;


    Purchase addPurchase(Purchase purchase);


    boolean updatePurchase(Purchase purchase);


    boolean deletePurchase(String eventID, String purchaseID);


    boolean joinEvent(String EventID, String Password);


    void getAllEvents(LoadEventsCallback callback) throws InterruptedException;


    void getAllPurchases(LoadPurchasesCallback callback);



    interface LoadEventsCallback{
        void onLoad(List<Event> events);
    }

    interface LoadPurchasesCallback{
        void onLoad(List<Purchase> purchases);
    }
}

