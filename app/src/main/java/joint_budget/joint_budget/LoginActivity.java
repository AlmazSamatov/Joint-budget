package joint_budget.joint_budget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import joint_budget.joint_budget.API.FIrebaseAPI.FirebaseEventsAPI;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FirebaseEventsAPI api = new FirebaseEventsAPI();


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

