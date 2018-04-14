package joint_budget.joint_budget.Events.Events;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import joint_budget.joint_budget.DataTypes.Event;
import joint_budget.joint_budget.Events.Choice.ChoiceActivity;
import joint_budget.joint_budget.Events.CreateEvent.ParticipantsAdapter;
import joint_budget.joint_budget.R;

public class EventsActivity extends AppCompatActivity implements EventsView {

    private EventsPresenterInterface presenter;
    @BindView(R.id.events_add_event)
    FloatingActionButton createEvent;
    @BindView(R.id.events_listView)
    ListView eventsListView;
    @BindView(R.id.empty_events)
    TextView emptyEvents;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        try {
            initialize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initialize() throws IOException {
        ButterKnife.bind(this);
        presenter = new EventsPresenter(this, getApplicationContext());
        presenter.loadEvents();
    }

    @Override
    public void onEventCreate(View view) {
        Intent intent = new Intent(getBaseContext(), ChoiceActivity.class);
        startActivity(intent);
    }

    @Override
    public void showEvents(List<Event> events) {

        EventsAdapter eventsAdapter = new EventsAdapter(this, R.layout.event_item, events);
        eventsListView.setEmptyView(emptyEvents);
        eventsListView.setAdapter(eventsAdapter);
    }

}
