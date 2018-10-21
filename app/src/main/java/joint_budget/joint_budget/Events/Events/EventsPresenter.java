package joint_budget.joint_budget.Events.Events;

import android.content.Context;
import android.content.Intent;

import java.io.IOException;
import java.util.List;

import joint_budget.joint_budget.API.EventsAPI;
import joint_budget.joint_budget.DataTypes.Event;
import joint_budget.joint_budget.Model.EventsModel;

public class EventsPresenter implements EventsPresenterInterface {

    private EventsView view;
    private EventsModel eventModel;
    private String userID;

    EventsPresenter(EventsView view, Context context) throws IOException {
        this.view = view;
        eventModel = EventsModel.getInstance();
    }

    @Override
    public void createEvent(Event event) throws IOException{
        eventModel.addEvent(event);
    }

    @Override
    public void editEvent(Event event) {
        eventModel.editEvent(event);
    }

    @Override
    public void deleteEvent(Event event) {
        if(event.getParticipants().get(0).getUserID().equals(userID)){
            eventModel.deleteEvent(event.getEventId());
            view.updateListView();
        } else{
            view.showError("You can not delete this event");
        }
    }

    @Override
    public void loadEvents() {
        view.turnOnPrgressBar();
        eventModel.getEvents(userID, new EventsAPI.LoadEventsCallback() {
            @Override
            public void onLoad(List<Event> events) {
                eventModel.setEvents(events);
                view.turnOffPrgressBar();
                view.showEvents(eventModel.getEventsLocal());
            }
        });
    }

    @Override
    public void getCurrentUser(Intent intent) {
        userID = intent.getStringExtra("userID");
    }

    @Override
    public String getUserID() {
        return userID;
    }
}
