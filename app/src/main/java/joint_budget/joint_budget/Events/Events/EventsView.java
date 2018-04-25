package joint_budget.joint_budget.Events.Events;

import android.view.View;

import java.util.List;

import joint_budget.joint_budget.DataTypes.Event;

interface EventsView {

    void onEventCreate(View view);
    void showEvents(List<Event> events);
    void deleteEvent(Event event);

    void turnOnPrgressBar();

    void turnOffPrgressBar();

    void editEvent(Event event);
    void updateListView();
}