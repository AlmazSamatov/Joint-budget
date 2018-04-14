package joint_budget.joint_budget.Events.CreateEvent;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import joint_budget.joint_budget.DataTypes.User;
import joint_budget.joint_budget.Events.AddParticipant.AddParticipantActivity;
import joint_budget.joint_budget.Events.Choice.ChoiceActivity;
import joint_budget.joint_budget.Events.Events.EventsActivity;
import joint_budget.joint_budget.R;

public class CreateEventActivity extends AppCompatActivity implements CreateEventView{

    private CreateEventPresenterInterface presenter;
    private ParticipantsAdapter participantsAdapter;
    private final int REQUEST_CODE = 1;

    @BindView(R.id.event_name) TextInputEditText eventName;
    @BindView(R.id.currency) Spinner currency;
    @BindView(R.id.start_date) TextView startDate;
    @BindView(R.id.final_date) TextView finalDate;
    @BindView(R.id.participants_list) ListView participantsList;
    @BindView(R.id.save_btn) Button save;
    @BindView(R.id.cancel_btn) Button cancel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);
        try {
            initialize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initialize() throws IOException {
        ButterKnife.bind(this);
        presenter = new CreateEventPresenter(this, getApplicationContext());
        presenter.setCurrentDate();
        showParticipants();
    }

    private void showParticipants() {
        participantsAdapter = new ParticipantsAdapter(this, R.layout.participant_item,
                presenter.getUsers());
        participantsList.setAdapter(participantsAdapter);
    }

    @Override
    public void setDates(String currentDate){
        setStartDate(currentDate);
        setFinalDate(currentDate);
    }

    @Override
    public void setStartDate(String date) {
        startDate.setText(date);
    }

    @Override
    public void setFinalDate(String date) {
        finalDate.setText(date);
    }

    public void onStartDateClick(View view) {
        showDatePicker(true);
    }

    public void onFinalDateClick(View view) {
        showDatePicker(false);
    }

    @Override
    public void showError(String errorMessage){
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    public void showDatePicker(boolean isStartDate){
        DialogFragment dateDialog = new DatePicker(this, isStartDate);
        dateDialog.show(getFragmentManager(), "datePicker");
    }

    public void addParticipants(View view) {
        Intent intent = new Intent(getApplicationContext(), AddParticipantActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            String username = data.getStringExtra("participantName");
            String participantLinkOrPhone = data.getStringExtra("participantLinkOrPhone");
            presenter.addNewParticipant(username, participantLinkOrPhone, participantsAdapter);
        }
    }

    public void cancelOnClick(View view) {
        startEventsActivity();
    }

    public void saveOnClick(View view) throws IOException, ParseException {
        presenter.saveEvent(eventName.getText().toString(), startDate.getText().toString(),
                finalDate.getText().toString(), currency.getSelectedItem().toString());
    }

    @Override
    public void startEventsActivity(){
        Intent intent = new Intent(getApplicationContext(), EventsActivity.class);
        startActivity(intent);
    }
}
