package joint_budget.joint_budget.ShoppingList;

import joint_budget.joint_budget.DataTypes.Event;
import joint_budget.joint_budget.DataTypes.ShoppingListItem;

public interface ShoppingListPresenter {
    void addPurchase(ShoppingListItem purchase, Event event);

    void editPurchase(ShoppingListItem purchase, Event event);

    void deletePurchase(ShoppingListItem purchase, Event event);
}
