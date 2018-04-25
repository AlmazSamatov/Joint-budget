package joint_budget.joint_budget.Events.Events;

import android.content.Intent;

import java.io.IOException;

import joint_budget.joint_budget.DataTypes.Event;

public interface EventsPresenterInterface {
    void createEvent(Event event) throws IOException;
    void editEvent(Event event);
    void deleteEvent(Event event);
    void loadEvents();
    void getCurrentUser(Intent intent);
    String getUserID();
}
