package joint_budget.joint_budget.Event.CreatePurchases;

import android.content.Intent;

import com.google.gson.Gson;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import joint_budget.joint_budget.DataTypes.Currency;
import joint_budget.joint_budget.DataTypes.Purchase;
import joint_budget.joint_budget.DataTypes.UserInfo;
import joint_budget.joint_budget.Events.CreateEvent.ParticipantsAdapter;
import joint_budget.joint_budget.Model.EventsModel;

public class CreatePurchasesPresenter implements CreatePurchasesPresenterInterface {

    private CreatePurchasesView view;
    private EventsModel model;
    private ArrayList<UserInfo> userInfos;
    UserInfo currentUserInfo;
    private Purchase previousPurchase;

    public CreatePurchasesPresenter(CreatePurchasesView view) throws IOException {
        this.view = view;
        model = EventsModel.getInstance();
        userInfos = new ArrayList<>();
        currentUserInfo = new UserInfo();
        addCurrentUser();
    }

    private void addCurrentUser() {
        currentUserInfo.setUserName("Ivan Ivanov");
        userInfos.add(currentUserInfo);
    }

    @Override
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
    public void savePurchase(String name, String cost, String currency) throws ParseException {
        double c = 0;
        if (name.trim().length() == 0) {
            view.showError("Event should has name");
        } else if (cost.trim().length() == 0) {
            view.showError("Enter cost");
        } else if (cost.trim().length() > 0){
            try{
                c = Double.parseDouble(cost);
            } catch (Exception e){
                view.showError("Incorrect cost");
            }
        } else {
            Purchase purchase = new Purchase();
            purchase.setCurrency(Currency.valueOf(currency));
            purchase.setPurchaseName(name);
            purchase.setTotalCost(c);
            //event.setEventId(previousEvent.getEventId());

            if (previousPurchase == null){
                model.addPurchase(purchase);
            } else{
                model.updatePurchase(previousPurchase, purchase);
            }

            view.startEventActivity();
        }
    }

    @Override
    public ArrayList<UserInfo> getUserInfos() {
        return userInfos;
    }


    @Override
    public void setPreviousPurchase(Intent intent) {
        String previousPurchaseInJson = intent.getStringExtra("PreviousPurchase");
        if(previousPurchaseInJson != null){
            Gson gson = new Gson();
            previousPurchase = gson.fromJson(previousPurchaseInJson, Purchase.class);
            view.setFields(previousPurchase);
        }
    }


}
