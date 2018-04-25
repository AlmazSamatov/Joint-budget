package joint_budget.joint_budget.Events.CreateEvent;

import android.content.Intent;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import joint_budget.joint_budget.DataTypes.UserInfo;

public interface CreateEventPresenterInterface {
    void setCurrentDate();

    void addNewParticipants(List<UserInfo> user, ParticipantsAdapter participantsAdapter);

    void saveEvent(String name, String startDate, String finalDate,
                   String currency) throws ParseException, IOException, InterruptedException;

    List<UserInfo> getUserInfos();
    void addNewParticipant(String username, String participantLinkOrPhone, ParticipantsAdapter participantsAdapter);
    void setPreviousEvent(Intent intent, ParticipantsAdapter participantsAdapter);
    String getDateInString(Date date);

    void getCurrentUser(Intent intent);

    String getUserID();
}
