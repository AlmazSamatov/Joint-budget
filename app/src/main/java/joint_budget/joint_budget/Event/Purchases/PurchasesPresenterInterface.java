package joint_budget.joint_budget.Event.Purchases;

import android.content.Intent;

import joint_budget.joint_budget.DataTypes.Purchase;

interface PurchasesPresenterInterface {
    void deletePurchase(Purchase purchase);
    void loadPurchases();

    void getCurrentUser(Intent intent);

    String getUserID();
}
