package joint_budget.joint_budget.Events.Events;

import android.content.Context;

import java.io.IOException;

import joint_budget.joint_budget.DataTypes.Event;
import joint_budget.joint_budget.DataTypes.UserInfo;

public class EventsPresenter implements EventsPresenterInterface {

    private EventsView view;
    private Model model;

    EventsPresenter(EventsView view, Context context) throws IOException {
        this.view = view;
        model = new Model(context);
    }

    @Override
    public void createEvent(Event event) throws IOException {
        model.addEvent(event);
    }

    @Override
    public void joinEvent(String ID, String password) {

    }

    @Override
    public void addParticipantToEvent(UserInfo userInfo, Event event) {

    }

    @Override
    public void deleteParticipantFromEvent(UserInfo userInfo, Event event) {

    }

    @Override
    public void editEvent(Event event) {

    }

    @Override
    public void deleteEvent(Event event) {

    }

    @Override
    public void loadEvents() {
        view.showEvents(model.getEvents());
    }
}
