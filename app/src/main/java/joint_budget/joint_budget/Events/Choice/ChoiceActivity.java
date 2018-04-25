package joint_budget.joint_budget.Events.Choice;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import joint_budget.joint_budget.Events.CreateEvent.CreateEventActivity;
import joint_budget.joint_budget.Events.JoinExistingEvent.JoinExistingEventActivity;
import joint_budget.joint_budget.R;

public class ChoiceActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
    }

    public void joinExistingEvent(View view) {
        Intent intent = new Intent(getBaseContext(), JoinExistingEventActivity.class);
        intent.putExtra("userID", getIntent().getStringExtra("userID"));
        startActivity(intent);
    }

    public void createNewEvent(View view) {
        Intent intent = new Intent(getBaseContext(), CreateEventActivity.class);
        intent.putExtra("userID", getIntent().getStringExtra("userID"));
        startActivity(intent);
    }
}