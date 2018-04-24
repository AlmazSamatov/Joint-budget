package joint_budget.joint_budget.Events.Events;

import android.content.Context;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import joint_budget.joint_budget.API.EventsAPI;
import joint_budget.joint_budget.DataTypes.Currency;
import joint_budget.joint_budget.DataTypes.Event;
import joint_budget.joint_budget.DataTypes.UserInfo;
import joint_budget.joint_budget.Model.EventsModel;

public class EventsPresenter implements EventsPresenterInterface {

    private EventsView view;
    private EventsModel eventModel;

    EventsPresenter(EventsView view, Context context) throws IOException {
        this.view = view;
        eventModel = EventsModel.getInstance();
    }

    @Override
    public void createEvent(Event event) throws IOException{
        eventModel.addEvent(event);
    }

    @Override
    public void joinEvent(String eventID, String password) {
        eventModel.joinEvent(eventID, password);
    }

    @Override
    public void addParticipantToEvent(UserInfo userInfo, Event event) {

    }

    @Override
    public void deleteParticipantFromEvent(UserInfo userInfo, Event event) {

    }

    @Override
    public void editEvent(Event event) {
        eventModel.editEvent(event);
    }

    @Override
    public void deleteEvent(Event event) {
        //eventModel.deleteEvent(event.getEventId());
        eventModel.deleteEventFromDB(event);
    }

    @Override
    public void loadEvents() {
        eventModel.getEventsFromDB(new EventsModel.LoadEventsFromDBCallback() {
            @Override
            public void onLoad(List<Event> events) {
                view.showEvents(events);
            }
        });

        /*eventModel.getEvents(new EventsAPI.LoadEventsCallback() {
            @Override
            public void onLoad(List<Event> events) {
                view.showEvents(events);
            }
        });*/
    }
}
