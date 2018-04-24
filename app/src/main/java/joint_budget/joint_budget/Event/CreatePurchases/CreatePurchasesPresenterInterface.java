package joint_budget.joint_budget.Event.CreatePurchases;

import android.content.Intent;

import java.text.ParseException;
import java.util.ArrayList;

import joint_budget.joint_budget.DataTypes.UserInfo;
import joint_budget.joint_budget.Events.CreateEvent.ParticipantsAdapter;

interface CreatePurchasesPresenterInterface {
    void addNewParticipants(ArrayList<UserInfo> user, ParticipantsAdapter participantsAdapter);
    void savePurchase(String name, String cost, String currency) throws ParseException;
    ArrayList<UserInfo> getUserInfos();
    void setPreviousPurchase(Intent intent);
    void addNewParticipant(String username, String participantLinkOrPhone, ParticipantsAdapter participantsAdapter);
}
