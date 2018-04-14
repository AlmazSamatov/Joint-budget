package joint_budget.joint_budget.API.FIrebaseAPI;

import android.content.Context;
import android.util.Pair;

import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import joint_budget.joint_budget.API.EventsAPI;
import joint_budget.joint_budget.DataTypes.Event;
import joint_budget.joint_budget.DataTypes.Purchase;

public class FirebaseEventsAPI implements EventsAPI {
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference referenceToEvents;

    public FirebaseEventsAPI(Context context) {
        FirebaseApp app = FirebaseApp.initializeApp(context);
        firebaseDatabase = FirebaseDatabase.getInstance(app);
        referenceToEvents = firebaseDatabase.getReference().child("events");
    }

    private static void completing(Task task) throws InterruptedException {
        while (!task.isComplete()) {
            Thread.sleep(500);
        }
    }

    @Override
    public Pair<String, Boolean> createEvent(Event event) throws InterruptedException {
        String key = referenceToEvents.push().getKey();
        event.setEventId(key);
        Task valueAdding = referenceToEvents.child(key).setValue(event);
        completing(valueAdding);
        return new Pair<>(key, valueAdding.isSuccessful());
    }

    @Override
    public boolean deleteEvent(String eventID) throws InterruptedException {
        Task valueAdding = referenceToEvents.child(eventID).removeValue();
        completing(valueAdding);
        return valueAdding.isSuccessful();
    }

    @Override
    public boolean updateEvent(Event event) throws InterruptedException {
        Task valueUpdating = referenceToEvents.child(event.getEventId()).updateChildren(EventToMap(event));
        completing(valueUpdating);
        return valueUpdating.isSuccessful();
    }

    @Override
    public boolean addPurchase(Purchase purchase) {
        return false;
    }

    @Override
    public boolean editPurchase(Purchase purchase) {
        return false;
    }

    @Override
    public boolean deletePurchase(String eventID, String purchaseID) {
        return false;
    }

    @Override
    public boolean joinEvent(String EventID, String Password) {
        return false;
    }

    @Override
    public void getAllEvents(final LoadEventsCallback callback) {

        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Event> events = new ArrayList<>();
                for (DataSnapshot eventSnapshot: dataSnapshot.getChildren()) {
                    events.add(eventSnapshot.getValue(Event.class));
                }
                callback.onLoad(events);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                throw new RuntimeException();
            }
        };
        referenceToEvents.addListenerForSingleValueEvent(eventListener);

    }

    @Override
    public void getAllPurchases(LoadPurchasesCallback callback) {
    }

    @Override
    public void subscribeToEventsUpdates() {

    }

    @Override
    public void subscribeToPurchasesUpdates() {

    }

    private Map<String, Object> EventToMap(Event event) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("EventId", event.getEventId());
        map.put("Currency", event.getCurrency());
        map.put("EndDate", event.getEndDate());
        map.put("Name", event.getName());
        map.put("StartDate", event.getStartDate());
        map.put("Participants", event.getParticipants());
        return map;
    }
}
