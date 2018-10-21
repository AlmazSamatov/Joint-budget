package joint_budget.joint_budget.Event.Purchases;

import android.os.Bundle;

import java.util.List;

import joint_budget.joint_budget.API.EventsAPI;
import joint_budget.joint_budget.DataTypes.Purchase;
import joint_budget.joint_budget.Model.EventsModel;

public class PurchasesPresenter implements PurchasesPresenterInterface {

    PurchasesView view;
    EventsModel model;
    private String userID;
    private String eventID;

    PurchasesPresenter(PurchasesView view){
        this.view = view;
        model = EventsModel.getInstance();
    }

    @Override
    public void deletePurchase(String userID, Purchase purchase) {
        if(this.userID.equals(userID))
            model.deletePurchase(purchase.getEventID(), purchase.getPurchaseID());
        else
            view.showError("You can not delete this purchase");
    }

    @Override
    public void loadPurchases() {
        view.turnOnProgressBar();
        model.getPurchases(new EventsAPI.LoadPurchasesCallback() {
            @Override
            public void onLoad(List<Purchase> purchases) {
                view.turnOffPrgoressBar();
                model.setPurchases(purchases);
                view.showPurchases(purchases);
            }
        }, eventID);
    }

    @Override
    public void getData(Bundle bundle) {
        if(bundle != null) {
            userID = bundle.getString("userID");
            eventID = bundle.getString("eventID");
        }
    }

    @Override
    public String getUserID() {
        return userID;
    }

    @Override
    public String getEventID() {
        return eventID;
    }

    @Override
    public void editEvent(String userID, Purchase purchase) {
        if(this.userID.equals(userID))
            view.launchCreatePurchaseActivity(purchase);
        else
            view.showError("You can not edit this purchase");
    }
}
