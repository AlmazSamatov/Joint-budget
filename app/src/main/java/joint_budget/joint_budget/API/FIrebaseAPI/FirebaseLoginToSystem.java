package joint_budget.joint_budget.API.FIrebaseAPI;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import joint_budget.joint_budget.API.LoginToSystemAPI;
import joint_budget.joint_budget.DataTypes.PrivateUserInfo;

public class FirebaseLoginToSystem implements LoginToSystemAPI {
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference mDatabase;
    private DatabaseReference databaseReference;

    public FirebaseLoginToSystem() {
        firebaseDatabase = FirebaseDatabase.getInstance("https://joint-budget-f59f7.firebaseio.com/");
        databaseReference = firebaseDatabase.getReference();
    }

    @Override
    public void login(String email, String password, final LoginCallback callback) {

        DatabaseReference referenceToUsers = databaseReference.child("users");
        Query account = referenceToUsers.orderByChild("email").equalTo(email);
        account.orderByChild("password").equalTo(password);
        ValueEventListener completeListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<PrivateUserInfo> users = new ArrayList<>();
                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    users.add(userSnapshot.getValue(PrivateUserInfo.class));
                }
                callback.onLogin(users);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                throw new RuntimeException();
            }
        };

        account.addListenerForSingleValueEvent(completeListener);
    }

    @Override
    public String register(PrivateUserInfo user) {
        String key = databaseReference.child("users").push().getKey();
        databaseReference.child("events").child(key).setValue(user);
        return key;
    }

    @Override
    public boolean recoverAccount(String email) {
        return false;
    }

    @Override
    public String getSavedLogPass() {
        return null;
    }
}

