package joint_budget.joint_budget.Event.Purchases;

import java.util.List;

import joint_budget.joint_budget.DataTypes.Purchase;

interface PurchasesView {
    void delete(String userID, Purchase purchase);

    void showPurchases(List<Purchase> purchases);

    void editPurchase(String userID, Purchase purchase);

    void turnOnProgressBar();

    void turnOffPrgoressBar();

    void showError(String error);

    void launchCreatePurchaseActivity(Purchase previousPurchase);
}
