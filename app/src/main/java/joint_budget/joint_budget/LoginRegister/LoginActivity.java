package joint_budget.joint_budget.LoginRegister;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import joint_budget.joint_budget.API.FIrebaseAPI.FirebaseEventsAPI;
import joint_budget.joint_budget.DataTypes.Event;
import joint_budget.joint_budget.R;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FirebaseEventsAPI api = new FirebaseEventsAPI(this);
        Event event = new Event();
        event.setName("afsf");
        try {
            api.createEvent(event);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

