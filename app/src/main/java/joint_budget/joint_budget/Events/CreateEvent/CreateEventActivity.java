package joint_budget.joint_budget.Events.CreateEvent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import joint_budget.joint_budget.R;

public class CreateEventActivity extends AppCompatActivity implements CreateEventView{

    private CreateEventPresenterInterface presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);
        initialize();
    }

    private void initialize() {
        presenter = new CreateEventPresenter();
    }

}
