package joint_budget.joint_budget.Event.CreatePurchases;

import android.content.Intent;

import java.text.ParseException;
import java.util.List;

import joint_budget.joint_budget.DataTypes.UserInfo;

interface CreatePurchasesPresenterInterface {
    void addNewParticipants(List<UserInfo> user);
    void savePurchase(String name, String cost, String currency) throws ParseException;
    List<UserInfo> getUserInfos();
    void setPreviousPurchase(Intent intent);
    void getData(Intent intent);
    String getUserID();
    void restoreParticipants();
}
