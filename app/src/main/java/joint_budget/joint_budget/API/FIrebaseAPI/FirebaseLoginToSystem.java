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
    private DatabaseReference referencesToUsers;

    public FirebaseLoginToSystem() {
        firebaseDatabase = FirebaseDatabase.getInstance("https://joint-budget-f59f7.firebaseio.com/");
        databaseReference = firebaseDatabase.getReference();
        referencesToUsers = databaseReference.child("users");
    }

    @Override
    public void login(String email, final String password, final LoginCallback callback) {
        DatabaseReference referenceToUsers = databaseReference.child("users");
        Query account = referenceToUsers.orderByChild("email").equalTo(email);
        ValueEventListener completeListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<PrivateUserInfo> users = new ArrayList<>();
                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    users.add(userSnapshot.getValue(PrivateUserInfo.class));
                }
                ArrayList<PrivateUserInfo> acceptedUsers = new ArrayList<>();
                for (int i = 0; i < users.size(); i++) {
                    if (users.get(i).getPassword().equals(password)) {
                        acceptedUsers.add(users.get(i));
                    }
                }
                callback.onLogin(acceptedUsers);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                throw new RuntimeException();
            }
        };

        account.addListenerForSingleValueEvent(completeListener);
    }

    @Override
    public void register(PrivateUserInfo user, RegisterCallback callback) {
        String key = referencesToUsers.push().getKey();
        user.setUserID(key);
        referencesToUsers.child(key).setValue(user);
        callback.onRegister(key);
    }

    @Override
    public void recoverAccount(String email, final LoginCallback callback) {
        DatabaseReference referenceToUsers = databaseReference.child("users");
        Query account = referenceToUsers.orderByChild("email").equalTo(email);
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
    public String getSavedLogPass() {
        return null;
    }

    public void getUserByID(String userID, final GetUserCallback callback) {
        DatabaseReference referenceToUsers = databaseReference.child("users");
        Query account = referenceToUsers.orderByChild("userID").equalTo(userID);
        ValueEventListener completeListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<PrivateUserInfo> users = new ArrayList<>();
                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    users.add(userSnapshot.getValue(PrivateUserInfo.class));
                }

                callback.onLoad(users);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                throw new RuntimeException();
            }
        };

        account.addListenerForSingleValueEvent(completeListener);
    }
}

