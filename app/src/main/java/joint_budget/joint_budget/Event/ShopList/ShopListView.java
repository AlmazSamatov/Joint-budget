package joint_budget.joint_budget.Event.ShopList;

import java.util.List;

import joint_budget.joint_budget.DataTypes.ShoppingListItem;

interface ShopListView {

    void delete(ShoppingListItem item);
    void edit(ShoppingListItem item);
    void showItems(List<ShoppingListItem> items);
    void launchShopListItemChange(ShoppingListItem shoppingListItem);
    void turnOnProgressBar();
    void turnOffProgressBar();
}
