package joint_budget.joint_budget.Events.AddParticipant;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import joint_budget.joint_budget.R;

public class AddParticipantActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_participant);
    }

    public void addParticipant(View view) {
        Intent intent = new Intent();
        String participantName = view.findViewById(R.id.participant_name).toString().trim();
        String participantLinkOrPhone = view.findViewById(R.id.link_or_phone_number).toString().trim();
        intent.putExtra("participantName", participantName);
        intent.putExtra("participantLinkOrPhone", participantLinkOrPhone);
        setResult(RESULT_OK, intent);
        finish();
    }


}
