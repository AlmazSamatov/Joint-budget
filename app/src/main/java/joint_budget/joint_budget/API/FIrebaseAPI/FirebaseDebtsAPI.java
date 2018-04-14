package joint_budget.joint_budget.API.FIrebaseAPI;

import android.content.Context;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.LinkedList;

import joint_budget.joint_budget.API.DebtsAPI;
import joint_budget.joint_budget.DataTypes.DebtPage;

public class FirebaseDebtsAPI extends DebtsAPI {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference referenceToDebts;

    public FirebaseDebtsAPI(Context context) {
        FirebaseApp app = FirebaseApp.initializeApp(context);
        firebaseDatabase = FirebaseDatabase.getInstance(app);
        referenceToDebts = firebaseDatabase.getReference().child("debts");
    }

    @Override
    public LinkedList<DebtPage> getAllDebts() {
        return super.getAllDebts();
    }

    @Override
    public void sendInvoice(String debtID) {
        super.sendInvoice(debtID);
    }

    @Override
    public void markAsReturned(String debtID) {
        super.markAsReturned(debtID);
    }
}
