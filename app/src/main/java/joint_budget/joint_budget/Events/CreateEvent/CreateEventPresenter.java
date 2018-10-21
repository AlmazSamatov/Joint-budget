package joint_budget.joint_budget.Events.CreateEvent;

import android.content.Context;
import android.content.Intent;

import com.google.gson.Gson;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import joint_budget.joint_budget.API.FIrebaseAPI.FirebaseLoginToSystem;
import joint_budget.joint_budget.API.LoginToSystemAPI;
import joint_budget.joint_budget.DataTypes.Currency;
import joint_budget.joint_budget.DataTypes.Event;
import joint_budget.joint_budget.DataTypes.PrivateUserInfo;
import joint_budget.joint_budget.DataTypes.UserInfo;
import joint_budget.joint_budget.Model.EventsModel;

public class CreateEventPresenter implements CreateEventPresenterInterface {

    private CreateEventView view;
    private EventsModel eventModel;
    private List<UserInfo> userInfos;
    private Event previousEvent;
    private String userID;
    private FirebaseLoginToSystem firebaseLoginToSystem;

    public CreateEventPresenter(CreateEventView view, Context context) throws IOException {
        this.view = view;
        eventModel = EventsModel.getInstance();
        userInfos = new LinkedList<>();
        firebaseLoginToSystem = new FirebaseLoginToSystem();
    }

    @Override
    public void addCurrentUser(final ParticipantsAdapter participantsAdapter) {
        firebaseLoginToSystem.getUserByID(userID, new LoginToSystemAPI.GetUserCallback() {
            @Override
            public void onLoad(List<PrivateUserInfo> users) {
                if(users.size() != 0) {
                    userInfos.add(users.get(0));
                    participantsAdapter.notifyDataSetChanged();
                }
            }
        });
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
    public void addNewParticipants(List<UserInfo> users, ParticipantsAdapter participantsAdapter) {
        userInfos.addAll(users);
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
            previousEvent.setName(name);
            previousEvent.setStartDate(beginningDate);
            previousEvent.setEndDate(endDate);
            previousEvent.setParticipants(userInfos);
            previousEvent.setCurrency(Currency.valueOf(currency));

            eventModel.updateEvent(previousEvent);

            view.startEventsActivity();
        }
    }

    @Override
    public List<UserInfo> getUserInfos() {
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

    public String getDateInString(Date date){
        String day          = (String) android.text.format.DateFormat.format("dd",   date);
        String monthNumber  = (String) android.text.format.DateFormat.format("MM",   date);
        String year         = (String) android.text.format.DateFormat.format("yyyy", date);
        String dayText = String.format("%02d", Integer.parseInt(day));
        String yearText = String.format("%02d", Integer.parseInt(year));
        String monthText = String.format("%02d", Integer.parseInt(monthNumber));
        String dateInString = dayText + '/' + monthText + '/' + yearText;
        return dateInString;
    }

    @Override
    public void getCurrentUser(Intent intent) {
        userID = intent.getStringExtra("userID");
    }

    @Override
    public String getUserID() {
        return userID;
    }

    @Override
    public Event getPreviousEvent(){
        return previousEvent;
    }
}
