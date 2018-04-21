package joint_budget.joint_budget.API.FIrebaseAPI;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import joint_budget.joint_budget.API.EventsAPI;
import joint_budget.joint_budget.DataTypes.Event;
import joint_budget.joint_budget.DataTypes.Purchase;

public class FirebaseEventsAPI implements EventsAPI {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference mDatabase;
    private DatabaseReference databaseReference;
    private DatabaseReference referenceToEvents;

    public FirebaseEventsAPI() {
        firebaseDatabase = FirebaseDatabase.getInstance("https://joint-budget-f59f7.firebaseio.com/");
        databaseReference = firebaseDatabase.getReference();
        referenceToEvents = databaseReference.child("events");
    }

    @Override
    public Event createEvent(Event event) {  // tested: works
        String key = referenceToEvents.push().getKey();
        event.setEventId(key);
        referenceToEvents.child(key).setValue(event);
        return event;
    }

    @Override
    public boolean deleteEvent(String eventID) { // tested:works
        Task valueAdding = referenceToEvents.child(eventID).removeValue();
        return valueAdding.isSuccessful();
    }

    @Override
    public boolean updateEvent(Event event) { //tested: works
        Task valueUpdating = referenceToEvents.child(event.getEventId()).setValue(event);
        return valueUpdating.isSuccessful();
    }

    @Override
    public Purchase addPurchase(Purchase purchase) { //tested:works
        DatabaseReference referenceToPurchases = referenceToEvents.child(purchase.getEventID()).child("purchases");
        String key = referenceToPurchases.push().getKey();
        purchase.setPurchaseID(key);
        referenceToPurchases.child(key).setValue(purchase);
        return purchase;
    }

    @Override
    public boolean updatePurchase(Purchase purchase) { //tested: works
        Task valueUpdating = databaseReference.child("events/" + purchase.getEventID() + "/purchases/" +
                purchase.getPurchaseID()).setValue(purchase);
        return valueUpdating.isSuccessful();
    }

    @Override
    public boolean deletePurchase(String eventID, String purchaseID) { //tested: works
        Task valueAdding = databaseReference.child("events/" + eventID + "/purchases/" +
                purchaseID).removeValue();
        return valueAdding.isSuccessful();
    }

    @Override
    public boolean joinEvent(String EventID, String Password) {
        return false;
    }

    @Override
    public void getAllEvents(final LoadEventsCallback callback, String userID) {//tested
        DatabaseReference referenceToEvents = databaseReference.child("events");
        Query allEvents = referenceToEvents.orderByChild("participants/userID").equalTo(userID);
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Event> events = new ArrayList<>();
                for (DataSnapshot eventSnapshot : dataSnapshot.getChildren()) {
                    events.add(eventSnapshot.getValue(Event.class));
                }
                callback.onLoad(events);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                throw new RuntimeException();
            }
        };

        allEvents.addListenerForSingleValueEvent(eventListener);

    }

    @Override
    public void getAllPurchases(final LoadPurchasesCallback callback, String EventID) { //tested: works
        DatabaseReference referenceToPurchase = databaseReference.child("events/" + EventID + "/purchases");
        ValueEventListener purchaseListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Purchase> purchases = new ArrayList<>();
                for (DataSnapshot purchaseSnapshot : dataSnapshot.getChildren()) {
                    purchases.add(purchaseSnapshot.getValue(Purchase.class));
                }
                callback.onLoad(purchases);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                throw new RuntimeException();
            }
        };

        referenceToPurchase.addListenerForSingleValueEvent(purchaseListener);
    }

}
