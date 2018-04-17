package joint_budget.joint_budget.Events.CreateEvent;

import android.content.Context;

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

    public CreateEventPresenter(CreateEventView view, Context context) throws IOException {
        this.view = view;
        eventModel = EventsModel.getInstance();
        userInfos = new ArrayList<>();
        addCurrentUser();
    }

    private void addCurrentUser() {
        UserInfo currentUserInfo = new UserInfo();
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
    public void saveEvent(String name, String startDate, String finalDate,
                          String currency) throws ParseException, IOException {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date beginningDate = format.parse(startDate);
        Date endDate = format.parse(finalDate);
        if(name.trim().length() == 0){
            view.showError("Event should has name");
        } else if(endDate.before(beginningDate)){
            view.showError("Final date should be after start date");
        } else{
            Event event = new Event();
            event.setName(name);
            event.setStartDate(beginningDate);
            event.setEndDate(endDate);
            event.setParticipants(userInfos);
            event.setCurrency(Currency.valueOf(currency));
            eventModel.addEvent(event);
            view.startEventsActivity();
        }
    }

    @Override
    public ArrayList<UserInfo> getUserInfos() {
        return userInfos;
    }
}
