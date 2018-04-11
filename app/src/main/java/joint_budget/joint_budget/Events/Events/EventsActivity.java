package joint_budget.joint_budget.Events.Events;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import joint_budget.joint_budget.Events.Choice.ChoiceActivity;
import joint_budget.joint_budget.R;

public class EventsActivity extends AppCompatActivity implements EventsView {

    private EventsPresenterInterface presenter;
    @BindView(R.id.events_add_event)
    FloatingActionButton createEvent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        initialize();
    }

    private void initialize() {
        presenter = new EventsPresenter();
        ButterKnife.bind(this);
    }

    @Override
    public void onEventCreate(View view) {
        Intent intent = new Intent(getBaseContext(), ChoiceActivity.class);
        startActivity(intent);
    }


}
