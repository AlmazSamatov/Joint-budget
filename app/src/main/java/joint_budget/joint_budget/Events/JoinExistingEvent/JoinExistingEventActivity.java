package joint_budget.joint_budget.Events.JoinExistingEvent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import joint_budget.joint_budget.Events.CreateEvent.CreateEventPresenter;
import joint_budget.joint_budget.Events.CreateEvent.CreateEventPresenterInterface;
import joint_budget.joint_budget.Events.CreateEvent.CreateEventView;
import joint_budget.joint_budget.R;

public class JoinExistingEventActivity extends AppCompatActivity implements JoinExistingEventView {

    private JoinExistingEventPresenterInterface presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_existing);
        initialize();
    }

    private void initialize() {
        presenter = new JoinExistingEventPresenter();
    }

}
