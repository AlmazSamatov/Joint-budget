package joint_budget.joint_budget.Event.ShopList;

import android.content.Intent;

import joint_budget.joint_budget.DataTypes.ShoppingListItem;

public interface ShopListPresenterInterface {
    void addShoplistItem(ShoppingListItem item);

    void editShoplistItem(ShoppingListItem item);

    void deleteShoplistItem(ShoppingListItem item);

    void loadItems();

    void setEvent(Intent intent);

    void getCurrentUser(Intent intent);

    String getUserID();
}
