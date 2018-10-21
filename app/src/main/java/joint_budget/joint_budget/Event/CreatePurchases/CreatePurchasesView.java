package joint_budget.joint_budget.Event.CreatePurchases;

import joint_budget.joint_budget.DataTypes.Purchase;

interface CreatePurchasesView {
    void showError(String error);
    void setFields(Purchase previousPurchase);
    void notifyDataSetChanged();
}
