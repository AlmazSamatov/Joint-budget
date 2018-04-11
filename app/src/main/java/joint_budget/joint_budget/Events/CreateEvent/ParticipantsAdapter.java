package joint_budget.joint_budget.Events.CreateEvent;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import joint_budget.joint_budget.DataTypes.User;
import joint_budget.joint_budget.R;

public class ParticipantsAdapter extends ArrayAdapter<User> {

    private List<User> users;
    @BindView(R.id.item_participant_name)
    TextView participantName;
    @BindView(R.id.delete_participant)
    ImageView deleteParticipant;

    public ParticipantsAdapter(@NonNull Context context, int resource, @NonNull List<User> objects) {
        super(context, resource, objects);
        users = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull final ViewGroup parent) {
        User user = users.get(position);
        View view = null;

        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(
                    R.layout.participant_item, parent, false);
        } else {
            view = convertView;
        }

        ButterKnife.bind(this, view);
        String userName = user.getFirstName() + ' ' + user.getLastName();
        participantName.setText(userName);
        deleteParticipant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                remove(users.get(parent.indexOfChild(view)));
            }
        });

        return view;
    }
}
