package joint_budget.joint_budget.Events.AddParticipant;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import joint_budget.joint_budget.R;

public class AddParticipantActivity extends AppCompatActivity {

    @BindView(R.id.participant_name)
    TextInputEditText participantName;
    @BindView(R.id.link_or_phone_number)
    TextInputEditText phoneNumber;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_participant);
        ButterKnife.bind(this);
    }

    public void addParticipant(View view) {
        Intent intent = new Intent();
        String participantNameText = participantName.getText().toString().trim();
        String participantLinkOrPhoneText = phoneNumber.getText().toString().trim();
        intent.putExtra("participantName", participantNameText);
        intent.putExtra("participantLinkOrPhone", participantLinkOrPhoneText);
        setResult(RESULT_OK, intent);
        finish();
    }

}
