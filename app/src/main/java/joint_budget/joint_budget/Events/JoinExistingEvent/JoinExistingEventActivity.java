package joint_budget.joint_budget.Events.JoinExistingEvent;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import joint_budget.joint_budget.API.EventsAPI;
import joint_budget.joint_budget.DataTypes.Event;
import joint_budget.joint_budget.Events.Events.EventsActivity;
import joint_budget.joint_budget.Model.EventsModel;
import joint_budget.joint_budget.R;

public class JoinExistingEventActivity extends AppCompatActivity {

    @BindView(R.id.join_event_id)
    EditText eventID;
    @BindView(R.id.join_pass)
    EditText pass;
    private String userID;
    private EventsModel eventsModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_existing);
        initialize();
    }

    private void initialize() {
        ButterKnife.bind(this);
        userID = getIntent().getStringExtra("userID");
        eventsModel = EventsModel.getInstance();
    }

    public void cancelOnClick(View view) {
        startEventsActivity();
    }

    public void saveOnClick(View view) {
       joinExisting();
    }

    private void joinExisting() {
        String eventId = eventID.getText().toString();
        String password = pass.getText().toString();
        if(eventId.trim().length() == 0)
            showError("Type eventID");
        else if(password.trim().length() == 0)
            showError("Type password");
        else{
            eventsModel.joinEvent(eventId, password, new EventsAPI.LoadEventsCallback() {
                @Override
                public void onLoad(List<Event> events) {
                    if(events.size() > 0){
                        startEventsActivity();
                    }
                }
            }, userID);
        }
    }

    private void showError(String error){
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    public void startEventsActivity(){
        Intent intent = new Intent(getApplicationContext(), EventsActivity.class);
        intent.putExtra("userID", getIntent().getStringExtra("userID"));
        startActivity(intent);
    }
}
