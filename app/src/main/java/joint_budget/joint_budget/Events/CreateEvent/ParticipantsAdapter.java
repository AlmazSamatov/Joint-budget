package joint_budget.joint_budget.Events.CreateEvent;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import joint_budget.joint_budget.DataTypes.UserInfo;
import joint_budget.joint_budget.R;

public class ParticipantsAdapter extends ArrayAdapter<UserInfo> {

    private ArrayList<UserInfo> userInfos;
    @BindView(R.id.item_participant_name)
    TextView participantName;
    @BindView(R.id.delete_participant)
    ImageView deleteParticipant;

    public ParticipantsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<UserInfo> objects) {
        super(context, resource, objects);
        userInfos = objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull final ViewGroup parent) {
        UserInfo userInfo = userInfos.get(position);
        View view = null;

        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(
                    R.layout.participant_item, parent, false);
        } else {
            view = convertView;
        }

        ButterKnife.bind(this, view);
        String userName = userInfo.getUserName();
        participantName.setText(userName);
        if(position == 0)
            deleteParticipant.setVisibility(View.GONE);
        else
            deleteParticipant.setVisibility(View.VISIBLE);
        deleteParticipant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                remove(userInfos.get(position));
            }
        });

        return view;
    }
}
