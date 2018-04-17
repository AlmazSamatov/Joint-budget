package joint_budget.joint_budget.Events.Events;

import java.io.IOException;

import joint_budget.joint_budget.DataTypes.Event;
import joint_budget.joint_budget.DataTypes.UserInfo;

public interface EventsPresenterInterface {
    void createEvent(Event event) throws IOException;
    void joinEvent(String ID, String password);

    void addParticipantToEvent(UserInfo userInfo, Event event);

    void deleteParticipantFromEvent(UserInfo userInfo, Event event);
    void editEvent(Event event);
    void deleteEvent(Event event);
    void loadEvents();
}
