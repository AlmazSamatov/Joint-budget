package joint_budget.joint_budget.API.FIrebaseAPI;

import android.content.Context;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.LinkedList;

import joint_budget.joint_budget.API.DebtsAPI;
import joint_budget.joint_budget.DataTypes.Debt;

public class FirebaseDebtsAPI extends DebtsAPI {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference referenceToDebts;
    private DatabaseReference databaseReference;

    public FirebaseDebtsAPI() {
        firebaseDatabase = FirebaseDatabase.getInstance("https://joint-budget-f59f7.firebaseio.com/");
        databaseReference = firebaseDatabase.getReference();
        referenceToDebts = firebaseDatabase.getReference().child("debts");
    }

    @Override
    public void getAllDebts(LoadDebtsCallback callback) { }

    @Override
    public void sendInvoice(String debtID) {
        super.sendInvoice(debtID);
    }

    @Override
    public void markAsReturned(String debtID) {
        super.markAsReturned(debtID);
    }
}
