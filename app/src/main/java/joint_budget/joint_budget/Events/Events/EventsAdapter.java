package joint_budget.joint_budget.Events.Events;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import joint_budget.joint_budget.DataTypes.Event;
import joint_budget.joint_budget.R;

public class EventsAdapter extends ArrayAdapter<Event> {

    private EventsView eventView;
    private List<Event> events;
    @BindView(R.id.title_event_item)
    TextView title;
    @BindView(R.id.second_field)
    TextView date;
    @BindView(R.id.participants_number)
    TextView participantsAmount;
    @BindView(R.id.delete_event)
    ImageButton deleteEvent;
    @BindView(R.id.edit_event)
    ImageButton editEvent;

    public EventsAdapter(@NonNull Context context, int resource, @NonNull List<Event> objects, EventsView view) {
        super(context, resource, objects);
        events = objects;
        this.eventView = view;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull final ViewGroup parent) {
        final Event event = events.get(position);
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

        deleteEvent.setFocusable(false);
        deleteEvent.setFocusableInTouchMode(false);
        deleteEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eventView.deleteEvent(event);
            }
        });

        editEvent.setFocusable(false);
        editEvent.setFocusableInTouchMode(false);
        editEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eventView.editEvent(event);
            }
        });

        return view;
    }
}