package joint_budget.joint_budget.API.FIrebaseAPI;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import joint_budget.joint_budget.API.EventsAPI;
import joint_budget.joint_budget.DataTypes.Event;
import joint_budget.joint_budget.DataTypes.Purchase;

public class FirebaseEventsAPI implements EventsAPI {
    FirebaseDatabase firebaseDatabase;
    private DatabaseReference mDatabase;
    private DatabaseReference databaseReference;

    public FirebaseEventsAPI() {
        firebaseDatabase = FirebaseDatabase.getInstance("https://joint-budget-f59f7.firebaseio.com/");
        databaseReference = firebaseDatabase.getReference();
    }

    @Override
    public Event createEvent(Event event) {
        String key = databaseReference.child("events").push().getKey();
        event.setEventId(key);
        databaseReference.child("events").child(key).setValue(event);
        return event;
    }

    @Override
    public boolean deleteEvent(String eventID) {
        Task valueAdding = databaseReference.child("events").child(eventID).removeValue();
        return valueAdding.isSuccessful();
    }

    @Override
    public boolean updateEvent(Event event) {
        Task valueUpdating = databaseReference.child("events").child(event.getEventId()).setValue(event);
        return valueUpdating.isSuccessful();
    }

    @Override
    public Purchase addPurchase(Purchase purchase) {
        String key = databaseReference.child("events").child(purchase.getEventID()).child("purchases").push().getKey();
        purchase.setPurchaseID(key);
        databaseReference.child("events").child(purchase.getEventID()).child(key).setValue(purchase);
        return purchase;
    }

    @Override
    public boolean updatePurchase(Purchase purchase) {
        Task valueUpdating = databaseReference.child("events/" + purchase.getEventID() + "purchases/" +
                purchase.getPurchaseID()).setValue(purchase);
        return valueUpdating.isSuccessful();
    }

    @Override
    public boolean deletePurchase(String eventID, String purchaseID) {
        Task valueAdding = databaseReference.child("events/" + eventID + "purchases/" +
                purchaseID).removeValue();
        return valueAdding.isSuccessful();
    }

    @Override
    public boolean joinEvent(String EventID, String Password) {
        return false;
    }

    @Override
    public LinkedList<Event> getAllEvents() {
        final LinkedList<Event> events = new LinkedList<>();
        databaseReference.child("events").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot eventSnapshot : dataSnapshot.getChildren()) {
                    events.add(eventSnapshot.getValue(Event.class));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                throw new RuntimeException();

            }
        });
        return events;
    }

    @Override
    public LinkedList<Purchase> getAllPurchases() {
        return null;
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
