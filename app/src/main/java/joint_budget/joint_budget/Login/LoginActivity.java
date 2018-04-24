package joint_budget.joint_budget.Login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import joint_budget.joint_budget.API.FIrebaseAPI.FirebaseEventsAPI;
import joint_budget.joint_budget.DataTypes.Event;
import joint_budget.joint_budget.DataTypes.UserInfo;
import joint_budget.joint_budget.R;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements LoginView {

    LoginPresenterInterface presenter;

    LoginActivity(){
        presenter = new LoginPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FirebaseEventsAPI api = new FirebaseEventsAPI();
        Event event = new Event();
        event.setName("test");
        event = api.createEvent(event);
        UserInfo userInfo = new UserInfo();
        userInfo.setFirstName("a");
        ArrayList<UserInfo> list = new ArrayList<>();
        list.add(userInfo);
        list.add(userInfo);
        event.setParticipants(list);


//        try {
//            api.createEvent(event);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        try {
//
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

}

