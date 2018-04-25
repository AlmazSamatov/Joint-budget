package joint_budget.joint_budget.Event.Purchases;

import java.util.List;

import joint_budget.joint_budget.DataTypes.Purchase;

interface PurchasesView {
    void delete(Purchase purchase);

    void showPurchases(List<Purchase> purchases);

    void editPurchase(Purchase purchase);
}
