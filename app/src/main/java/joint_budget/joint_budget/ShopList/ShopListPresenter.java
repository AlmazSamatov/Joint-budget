package joint_budget.joint_budget.ShopList;

import joint_budget.joint_budget.DataTypes.Event;
import joint_budget.joint_budget.DataTypes.ShoppingList;

public interface ShopListPresenter {
    void addPurchase(ShoppingList purchase, Event event);

    void editPurchase(ShoppingList purchase, Event event);

    void deletePurchase(ShoppingList purchase, Event event);
}
