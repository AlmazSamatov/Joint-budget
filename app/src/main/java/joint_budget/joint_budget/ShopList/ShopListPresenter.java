package joint_budget.joint_budget.ShoppingList;

import joint_budget.joint_budget.DataTypes.Event;
import joint_budget.joint_budget.DataTypes.ShoppingList;

public interface ShoppingListPresenter {
    void addPurchase(ShoppingList purchase, Event event);

    void editPurchase(ShoppingList purchase, Event event);

    void deletePurchase(ShoppingList purchase, Event event);
}
