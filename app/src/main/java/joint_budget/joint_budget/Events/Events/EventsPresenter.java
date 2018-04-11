package joint_budget.joint_budget.Events.Events;

import joint_budget.joint_budget.API.EventsAPI;
import joint_budget.joint_budget.DataTypes.Event;
import joint_budget.joint_budget.DataTypes.User;

public class EventsPresenter implements EventsPresenterInterface {

    private EventsView view;
    private EventsAPI model;

    EventsPresenter(){
        view = new EventsActivity();
    }

    @Override
    public void createEvent(Event event) {

    }

    @Override
    public void joinEvent(String ID, String password) {

    }

    @Override
    public void addParticipantToEvent(User user, Event event) {

    }

    @Override
    public void deleteParticipantFromEvent(User user, Event event) {

    }

    @Override
    public void editEvent(Event event) {

    }

    @Override
    public void deleteEvent(Event event) {

    }
}
