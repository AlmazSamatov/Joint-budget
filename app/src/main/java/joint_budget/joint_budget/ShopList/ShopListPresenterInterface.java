package joint_budget.joint_budget.ShopList;

import joint_budget.joint_budget.DataTypes.Event;
import joint_budget.joint_budget.DataTypes.ShoppingListItem;

public interface ShopListPresenterInterface {
    void addPurchase(ShoppingListItem purchase, Event event);

    void editPurchase(ShoppingListItem purchase, Event event);

    void deletePurchase(ShoppingListItem purchase, Event event);
}
