package joint_budget.joint_budget.Event.Purchases;

import joint_budget.joint_budget.DataTypes.Purchase;

interface PurchasesPresenterInterface {
    void deletePurchase(Purchase purchase);
    void loadPurchases();
}
