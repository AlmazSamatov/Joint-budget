package joint_budget.joint_budget.Events.Choice;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.gson.Gson;

import joint_budget.joint_budget.DataTypes.Event;
import joint_budget.joint_budget.Events.CreateEvent.CreateEventActivity;
import joint_budget.joint_budget.Events.JoinExistingEvent.JoinExistingEventActivity;
import joint_budget.joint_budget.Model.EventsModel;
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
        String eventInJSON = createEventAndReturnJSON();
        intent.putExtra("PreviousEvent", eventInJSON);
        intent.putExtra("userID", getIntent().getStringExtra("userID"));
        startActivity(intent);
    }

    private String createEventAndReturnJSON() {
        EventsModel eventsModel = EventsModel.getInstance();
        Event event = eventsModel.addEvent(new Event());
        Gson gson = new Gson();
        return gson.toJson(event, Event.class);
    }
}