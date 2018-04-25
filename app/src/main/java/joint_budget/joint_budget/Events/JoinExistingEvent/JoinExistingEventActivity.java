package joint_budget.joint_budget.Events.JoinExistingEvent;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import joint_budget.joint_budget.Events.Events.EventsActivity;
import joint_budget.joint_budget.R;

public class JoinExistingEventActivity extends AppCompatActivity {

    @BindView(R.id.join_event_id)
    EditText eventID;
    @BindView(R.id.join_pass)
    EditText pass;
    private String userID;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_existing);
        initialize();
    }

    private void initialize() {
        ButterKnife.bind(this);
        userID = getIntent().getStringExtra("userID");
    }


    public void cancelOnClick(View view) {
        startEventsActivity();
    }

    public void saveOnClick(View view) {
        joinExisting();
        startEventsActivity();
    }

    private void joinExisting() {
        // join
    }

    public void startEventsActivity(){
        Intent intent = new Intent(getApplicationContext(), EventsActivity.class);
        startActivity(intent);
    }
}
