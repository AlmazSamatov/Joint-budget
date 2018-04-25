package joint_budget.joint_budget.Login;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.List;

import joint_budget.joint_budget.API.FIrebaseAPI.FirebaseLoginToSystem;
import joint_budget.joint_budget.API.LoginToSystemAPI;
import joint_budget.joint_budget.DataTypes.PrivateUserInfo;

public class LoginPresenter implements LoginPresenterInterface {

    LoginView view;
    private FirebaseLoginToSystem firebaseLoginToSystem;
    private SharedPreferences sharedPreferences;
    private final String NAME_OF_SHARED_PREF = "userData";

    LoginPresenter(LoginView view, Context context){
        this.view = view;
        sharedPreferences = context.getSharedPreferences(NAME_OF_SHARED_PREF, Context.MODE_PRIVATE);
        firebaseLoginToSystem = new FirebaseLoginToSystem();
    }

    @Override
    public void login(String login, String password) {
        if(login.trim().length() == 0){
            view.showError("Type login");
            view.turnOffProgressBar();
        } else if(password.trim().length() == 0){
            view.showError("Type password");
            view.turnOffProgressBar();
        } else{
            firebaseLoginToSystem.login(login, password, new LoginToSystemAPI.LoginCallback() {
                @Override
                public void onLogin(List<PrivateUserInfo> account) {
                    view.turnOffProgressBar();
                    if(account.size() == 0){
                        view.showError("Incorrect login and/or password");
                    } else{
                        saveUserID(account.get(0).getUserID());
                        view.launchEventsActivity(account.get(0).getUserID());
                    }
                }
            });
        }
    }

    @Override
    public void loginGoogle(String login, String password) {

    }

    @Override
    public void resetPassword(String email) {

    }

    private void saveUserID(String userID){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("userID", userID);
        editor.apply();
    }

    private String getUserID(){
        return sharedPreferences.getString("userID", "");
    }

    @Override
    public void checkLoggedIn() {
        String userID = getUserID();
        if(userID.length() > 0)
            view.launchEventsActivity(userID);
    }
}
