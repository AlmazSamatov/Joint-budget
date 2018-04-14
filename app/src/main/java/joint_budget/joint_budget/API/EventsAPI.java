package joint_budget.joint_budget.API;

import android.util.Pair;

import java.util.LinkedList;
import java.util.List;

import joint_budget.joint_budget.DataTypes.Event;
import joint_budget.joint_budget.DataTypes.Purchase;


public interface EventsAPI {


    Pair<String, Boolean> createEvent(Event event) throws InterruptedException;


    boolean deleteEvent(String eventID) throws InterruptedException;


    boolean updateEvent(Event event) throws InterruptedException;


    boolean addPurchase(Purchase purchase);


    boolean editPurchase(Purchase purchase);


    boolean deletePurchase(String eventID, String purchaseID);


    boolean joinEvent(String EventID, String Password);


    void getAllEvents(LoadEventsCallback callback);


    void getAllPurchases(LoadPurchasesCallback callback);


    void subscribeToEventsUpdates();


    void subscribeToPurchasesUpdates();

    interface LoadEventsCallback{
        void onLoad(List<Event> events);
    }

    interface LoadPurchasesCallback{
        void onLoad(List<Purchase> purchases);
    }
}

