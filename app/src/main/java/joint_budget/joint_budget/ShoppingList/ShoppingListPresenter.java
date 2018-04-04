package joint_budget.joint_budget.ShoppingList;

import joint_budget.joint_budget.DataTypes.Event;
import joint_budget.joint_budget.DataTypes.ShoppingListPurchase;

public interface ShoppingListPresenter {
    void addPurchase(ShoppingListPurchase purchase, Event event);
    void editPurchase(ShoppingListPurchase purchase, Event event);
    void deletePurchase(ShoppingListPurchase purchase, Event event);
}
