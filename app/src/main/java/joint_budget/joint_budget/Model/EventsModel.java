package joint_budget.joint_budget.Model;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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

    public void addEvent(Event event)  {
        events.add(event);
        saveEventsToDB();
    }

    private void saveEventsToDB() {

    }

    private void deleteEventsFromDB(){

    }

    private void getEventsFromDB(LoadEventsFromDBCallback callback) {

    }

    public void updateEvent(Event event){}

    public List<Event> getEvents(){
        return events;
    }

    interface LoadEventsFromDBCallback{
        void onLoad(List<Event> events);
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
