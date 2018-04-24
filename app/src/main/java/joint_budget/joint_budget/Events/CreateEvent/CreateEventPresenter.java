package joint_budget.joint_budget.Events.CreateEvent;

import android.content.Context;
import android.content.Intent;

import com.google.gson.Gson;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import joint_budget.joint_budget.DataTypes.Currency;
import joint_budget.joint_budget.DataTypes.Event;
import joint_budget.joint_budget.DataTypes.UserInfo;
import joint_budget.joint_budget.Model.EventsModel;

public class CreateEventPresenter implements CreateEventPresenterInterface {

    private CreateEventView view;
    private EventsModel eventModel;
    private ArrayList<UserInfo> userInfos;
    UserInfo currentUserInfo;
    private Event previousEvent;

    public CreateEventPresenter(CreateEventView view, Context context) throws IOException {
        this.view = view;
        eventModel = EventsModel.getInstance();
        userInfos = new ArrayList<>();
        currentUserInfo = new UserInfo();
        addCurrentUser();
    }

    private void addCurrentUser() {
        currentUserInfo.setUserName("Ivan Ivanov");
        userInfos.add(currentUserInfo);
    }

    @Override
    public void setCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        view.setDates(dateFormat.format(date));
    }

    public void addNewParticipant(String username, String participantLinkOrPhone,
                                  ParticipantsAdapter adapter){
        if(username.length() > 0){
            UserInfo userInfo = new UserInfo();
            userInfo.setUserName(username);
            userInfo.setPhoneNumber(participantLinkOrPhone);
            userInfos.add(userInfo);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void addNewParticipants(ArrayList<UserInfo> user, ParticipantsAdapter participantsAdapter) {
        for(int i = 1; i < user.size(); i++)
            userInfos.add(user.get(i));
        participantsAdapter.notifyDataSetChanged();
    }

    @Override
    public void saveEvent(String name, String startDate, String finalDate,
                          String currency) throws ParseException, IOException, InterruptedException {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date beginningDate = format.parse(startDate);
        Date endDate = format.parse(finalDate);
        if(name.trim().length() == 0){
            view.showError("Event should has name");
        } else if(endDate.before(beginningDate)){
            view.showError("Final date should be after start date");
        } else {
            Event event = new Event();
            event.setName(name);
            event.setStartDate(beginningDate);
            event.setEndDate(endDate);
            event.setParticipants(userInfos);
            event.setCurrency(Currency.valueOf(currency));
            //event.setEventId(previousEvent.getEventId());

            if (previousEvent == null){
                eventModel.addEvent(event);
            } else{
                eventModel.updateEvent(previousEvent, event);
            }

            view.startEventsActivity();
        }
    }

    @Override
    public ArrayList<UserInfo> getUserInfos() {
        return userInfos;
    }

    public void setPreviousEvent(Intent intent) {
        String previousEventInJson = intent.getStringExtra("PreviousEvent");
        if(previousEventInJson != null){
            Gson gson = new Gson();
            previousEvent = gson.fromJson(previousEventInJson, Event.class);
            view.setFields(previousEvent);
        }
    }
}
