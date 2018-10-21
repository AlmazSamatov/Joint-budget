package joint_budget.joint_budget.Event.CreatePurchases;

import android.content.Intent;

import com.google.gson.Gson;

import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import joint_budget.joint_budget.DataTypes.Currency;
import joint_budget.joint_budget.DataTypes.Event;
import joint_budget.joint_budget.DataTypes.Purchase;
import joint_budget.joint_budget.DataTypes.PurchaseItem;
import joint_budget.joint_budget.DataTypes.UserInfo;
import joint_budget.joint_budget.Model.DebtsModel;
import joint_budget.joint_budget.Model.EventsModel;

public class CreatePurchasesPresenter implements CreatePurchasesPresenterInterface {

    private CreatePurchasesView view;
    private EventsModel model;
    private List<UserInfo> userInfos;
    private String userID;
    private Purchase previousPurchase;
    private String eventID;
    private Event event;

    public CreatePurchasesPresenter(CreatePurchasesView view) throws IOException {
        this.view = view;
        model = EventsModel.getInstance();
        userInfos = new LinkedList<>();
    }

    @Override
    public void addNewParticipants(List<UserInfo> users) {
        userInfos.addAll(users);
        swapWithCreator();
        view.notifyDataSetChanged();
    }

    @Override
    public void savePurchase(String name, String cost, String currency) throws ParseException {
        double c = 0;
        if (name.trim().length() == 0) {
            view.showError("Event should has name");
        } else if (cost.trim().length() == 0) {
            view.showError("Enter cost");
        }

        try{
            c = Double.parseDouble(cost);
        } catch (Exception e){
            view.showError("Incorrect cost");
        }

        if(c > 0){
            Purchase purchase = new Purchase();
            purchase.setCurrency(Currency.valueOf(currency));
            purchase.setPurchaseName(name);
            purchase.setTotalCost(c);
            PurchaseItem purchaseItem = new PurchaseItem();
            purchaseItem.setCostOfPurchase(c);
            purchaseItem.setParticipantsOfPurchase(userInfos);
            LinkedList<PurchaseItem> purchaseItems = new LinkedList<>();
            purchaseItems.add(purchaseItem);
            purchase.setPurchaseItems(purchaseItems);
            purchase.setEventID(eventID);

            if (previousPurchase == null){
                model.addPurchase(purchase);
                DebtsModel debtsModel = DebtsModel.getInstance();
                debtsModel.calculateDebts(purchase);
            } else{
                purchase.setPurchaseID(previousPurchase.getPurchaseID());
                model.updatePurchase(purchase);
            }
        } else{
            view.showError("Incorrect cost");
        }

    }

    @Override
    public List<UserInfo> getUserInfos() {
        return userInfos;
    }

    @Override
    public void setPreviousPurchase(Intent intent) {
        String previousPurchaseInJson = intent.getStringExtra("PreviousPurchase");
        if(previousPurchaseInJson != null){
            Gson gson = new Gson();
            previousPurchase = gson.fromJson(previousPurchaseInJson, Purchase.class);
            view.setFields(previousPurchase);
        } else{
            userInfos.addAll(event.getParticipants());
            swapWithCreator();
            view.notifyDataSetChanged();
        }
    }

    private void swapWithCreator() {
        for(int i = 1; i < userInfos.size(); i++){
            if(userInfos.get(i).getUserID() != null && userInfos.get(i).getUserID().equals(userID)){
                UserInfo userInfo = userInfos.get(0);
                userInfos.set(0, userInfos.get(i));
                userInfos.set(i, userInfo);
            }
        }

    }

    @Override
    public void getData(Intent intent) {
        userID = intent.getStringExtra("userID");
        eventID = intent.getStringExtra("eventID");
        String eventInJson = intent.getStringExtra("event");
        if(eventInJson != null){
            Gson gson = new Gson();
            event = gson.fromJson(eventInJson, Event.class);
        }
    }

    @Override
    public String getUserID() {
        return userID;
    }

    @Override
    public void restoreParticipants() {
        for(UserInfo user: event.getParticipants()){
            for(int i = 0; i < userInfos.size(); i++){
                if(i == userInfos.size() - 1 && !user.equals(userInfos.get(i))){
                    userInfos.add(user);
                }
                if(user.equals(userInfos.get(i)))
                    break;
            }
        }
        view.notifyDataSetChanged();
    }

}
