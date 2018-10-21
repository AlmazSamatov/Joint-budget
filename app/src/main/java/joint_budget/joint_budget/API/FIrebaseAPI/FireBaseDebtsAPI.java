package joint_budget.joint_budget.API.FIrebaseAPI;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import joint_budget.joint_budget.API.DebtsAPI;
import joint_budget.joint_budget.DataTypes.Debt;

public class FirebaseDebtsAPI implements DebtsAPI {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    public FirebaseDebtsAPI() {
        firebaseDatabase = FirebaseDatabase.getInstance("https://joint-budget-f59f7.firebaseio.com/");
        databaseReference = firebaseDatabase.getReference();
    }

    @Override
    public void getAllDebts(final LoadDebtsCallback callback, final String userID, final String eventID) {
        DatabaseReference referenceToEvents = databaseReference.child("debts");
        Query allDebts = referenceToEvents.orderByChild("amountOfDebt");
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Debt> debts = new ArrayList<>();
                for (DataSnapshot debtsSnapshot : dataSnapshot.getChildren()) {
                    Debt debt = debtsSnapshot.getValue(Debt.class);
                    if (debt.getCreditor().getUserID() != null && debt.getEventID().equals(eventID) && debt.getCreditor().getUserID().equals(userID)) {
                        debts.add(debt);
                    } else if(debt.getDebtor().getUserID() != null && debt.getEventID().equals(eventID) && debt.getDebtor().getUserID().equals(userID)){
                        debts.add(debt);
                    }
                }
                callback.onLoad(debts);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                throw new RuntimeException();
            }
        };

        allDebts.addValueEventListener(eventListener);

    }

    @Override
    public void sendInvoice(String debtID) {

    }

    @Override
    public void markAsReturned(String debtID) {//tested: works
        databaseReference.child("debts").child(debtID).removeValue();
    }

    @Override
    public String createDebt(Debt debt) {// tested: works
        DatabaseReference referenceToDebts = databaseReference.child("debts");
        String key = referenceToDebts.push().getKey();
        debt.setDebtID(key);
        referenceToDebts.child(key).setValue(debt);
        return key;
    }
}
