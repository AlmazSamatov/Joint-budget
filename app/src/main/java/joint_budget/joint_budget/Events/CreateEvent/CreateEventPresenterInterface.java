package joint_budget.joint_budget.Events.CreateEvent;

import android.content.Intent;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import joint_budget.joint_budget.DataTypes.UserInfo;

public interface CreateEventPresenterInterface {
    void setCurrentDate();
    void saveEvent(String name, String startDate, String finalDate,
                   String currency) throws ParseException, IOException, InterruptedException;

    ArrayList<UserInfo> getUserInfos();
    void addNewParticipant(String username, String participantLinkOrPhone, ParticipantsAdapter participantsAdapter);
    void setPreviousEvent(Intent intent);
    void addNewParticipants(ArrayList<UserInfo> user, ParticipantsAdapter participantsAdapter);
    String getDateInString(Date date);

    void getCurrentUser(Intent intent);

    String getUserID();
}
