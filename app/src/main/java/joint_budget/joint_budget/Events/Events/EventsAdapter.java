package joint_budget.joint_budget.Events.Events;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import joint_budget.joint_budget.DataTypes.Event;
import joint_budget.joint_budget.R;

public class EventsAdapter extends ArrayAdapter<Event> {

    private List<Event> events;
    @BindView(R.id.title_event_item)
    TextView title;
    @BindView(R.id.second_field)
    TextView date;
    @BindView(R.id.participants_number)
    TextView participantsAmount;

    public EventsAdapter(@NonNull Context context, int resource, @NonNull List<Event> objects) {
        super(context, resource, objects);
        events = objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull final ViewGroup parent) {
        Event event = events.get(position);
        View view = null;

        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(
                    R.layout.event_item, parent, false);
        } else {
            view = convertView;
        }

        ButterKnife.bind(this, view);

        title.setText(event.getName());
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        date.setText(dateFormat.format(event.getStartDate()));
        participantsAmount.setText(String.valueOf(event.getParticipants().size()));

        return view;
    }
}
