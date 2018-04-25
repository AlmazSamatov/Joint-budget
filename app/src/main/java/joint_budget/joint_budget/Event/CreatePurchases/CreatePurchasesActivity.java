package joint_budget.joint_budget.Event.CreatePurchases;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.text.ParseException;

import butterknife.BindView;
import butterknife.ButterKnife;
import joint_budget.joint_budget.DataTypes.Purchase;
import joint_budget.joint_budget.Events.AddParticipant.AddParticipantActivity;
import joint_budget.joint_budget.Events.CreateEvent.ParticipantsAdapter;
import joint_budget.joint_budget.R;

public class CreatePurchasesActivity extends AppCompatActivity implements CreatePurchasesView{

    private CreatePurchasesPresenterInterface presenter;
    private ParticipantsAdapter participantsAdapter;
    private final int REQUEST_CODE = 1;

    @BindView(R.id.purchase_name)
    TextInputEditText purchaseName;
    @BindView(R.id.currency)
    Spinner currency;
    @BindView(R.id.purchase_cost)
    TextInputEditText cost;
    @BindView(R.id.participants_list)
    ListView participantsList;
    @BindView(R.id.save_btn)
    Button save;
    @BindView(R.id.cancel_btn)
    Button cancel;

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
        presenter = new CreatePurchasesPresenter(this);
        showParticipants();
        presenter.setPreviousPurchase(getIntent());
    }

    private void showParticipants() {
        participantsAdapter = new ParticipantsAdapter(this, R.layout.participant_item,
                presenter.getUserInfos());
        participantsList.setAdapter(participantsAdapter);
    }

    @Override
    public void showError(String errorMessage){
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setFields(Purchase previousPurchase) {
        purchaseName.setText(previousPurchase.getPurchaseName());
        currency.setSelection(previousPurchase.getCurrency().ordinal());
        presenter.addNewParticipants(previousPurchase.getPurchaseItems().get(0).getParticipants(),
                participantsAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            String username = data.getStringExtra("participantName");
            String participantLinkOrPhone = data.getStringExtra("participantLinkOrPhone");
            presenter.addNewParticipant(username, participantLinkOrPhone, participantsAdapter);
        }
    }

    public void addParticipants(View view) {
        Intent intent = new Intent(getApplicationContext(), AddParticipantActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    public void cancelOnClick(View view) {
        finish();
    }

    public void saveOnClick(View view) throws IOException, ParseException, InterruptedException {
        presenter.savePurchase(purchaseName.getText().toString(),
                cost.getText().toString(), currency.getSelectedItem().toString());
        finish();
    }

}
