package joint_budget.joint_budget.Event.Purchases;
import android.content.Intent;

import joint_budget.joint_budget.DataTypes.Event;
import joint_budget.joint_budget.DataTypes.Purchase;
import joint_budget.joint_budget.Model.EventsModel;

public class PurchasesPresenter implements PurchasesPresenterInterface {

    PurchasesView view;
    EventsModel model;
    Event currentEvent;
    private String userID;

    PurchasesPresenter(PurchasesView view){
        this.view = view;
        model = EventsModel.getInstance();
    }

    @Override
    public void deletePurchase(Purchase purchase) {

        //model.deletePurchase(currentEvent, purchase);
    }

    @Override
    public void loadPurchases() {

    }

    @Override
    public void getCurrentUser(Intent intent) {
        userID = intent.getStringExtra("userID");
    }

    @Override
    public String getUserID() {
        return userID;
    }
}
