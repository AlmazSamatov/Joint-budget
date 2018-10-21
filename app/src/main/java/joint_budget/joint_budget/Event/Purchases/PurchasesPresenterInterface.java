package joint_budget.joint_budget.Event.Purchases;

import android.os.Bundle;

import joint_budget.joint_budget.DataTypes.Purchase;

interface PurchasesPresenterInterface {
    void deletePurchase(String userID, Purchase purchase);
    void loadPurchases();

    void getData(Bundle bundle);

    String getUserID();

    String getEventID();

    void editEvent(String userID, Purchase purchase);
}
