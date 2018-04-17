package joint_budget.joint_budget.API.FIrebaseAPI;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.LinkedList;

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
    public LinkedList<Debt> getAllDebts() {
        return null;
    }

    @Override
    public void sendInvoice(String debtID) {

    }

    @Override
    public void markAsReturned(String debtID) {
        databaseReference.child("debts").child(debtID).removeValue();
    }

    @Override
    public String createDebt(Debt debt) {
        DatabaseReference referenceToDebts = databaseReference.child("debts");
        String key = referenceToDebts.push().getKey();
        referenceToDebts.child(key).setValue(debt);
        return key;
    }
}
