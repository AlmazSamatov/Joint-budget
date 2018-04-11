package joint_budget.joint_budget.Events.Events;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.BindView;
import joint_budget.joint_budget.Events.CreateEvent.CreateEventActivity;
import joint_budget.joint_budget.R;

public class EventsActivity extends AppCompatActivity implements EventsView {

    private EventsPresenterInterface presenter;
    @BindView(R.id.add_event)
    FloatingActionButton createEvent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        initialize();
    }

    private void initialize() {
        presenter = new EventsPresenter();
    }

    @Override
    public void onEventCreate(View view) {
        Intent intent = new Intent(getBaseContext(), CreateEventActivity.class);
        startActivity(intent);
    }


}
