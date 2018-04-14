package joint_budget.joint_budget.API.FIrebaseAPI;

import android.content.Context;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import joint_budget.joint_budget.API.DebtsAPI;

public class FirebaseDebtsAPI extends DebtsAPI {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference referenceToDebts;

    public FirebaseDebtsAPI(Context context) {
        FirebaseApp app = FirebaseApp.initializeApp(context);
        firebaseDatabase = FirebaseDatabase.getInstance(app);
        referenceToDebts = firebaseDatabase.getReference().child("debts");
    }




}
