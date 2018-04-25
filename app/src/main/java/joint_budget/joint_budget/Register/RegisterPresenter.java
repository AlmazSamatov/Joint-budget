package joint_budget.joint_budget.Register;

import android.content.Context;
import android.content.SharedPreferences;

import joint_budget.joint_budget.API.FIrebaseAPI.FirebaseLoginToSystem;
import joint_budget.joint_budget.API.LoginToSystemAPI;
import joint_budget.joint_budget.DataTypes.PrivateUserInfo;

public class RegisterPresenter implements RegisterPresenterInterface {

    RegisterView view;
    FirebaseLoginToSystem firebaseLoginToSystem;
    private SharedPreferences sharedPreferences;
    private final String NAME_OF_SHARED_PREF = "userData";

    RegisterPresenter(RegisterView view, Context context){
        this.view = view;
        firebaseLoginToSystem = new FirebaseLoginToSystem();
        sharedPreferences = context.getSharedPreferences(NAME_OF_SHARED_PREF, Context.MODE_PRIVATE);
    }

    @Override
    public void register(PrivateUserInfo userInfo) {
        firebaseLoginToSystem.register(userInfo, new LoginToSystemAPI.RegisterCallback() {
            @Override
            public void onRegister(String userID) {
                saveUserID(userID);
                view.launchEventsActivity(userID);
            }
        });
    }

    private void saveUserID(String userID){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("userID", userID);
        editor.apply();
    }

}
