package joint_budget.joint_budget.Event.ShopList;

import android.os.Bundle;

import joint_budget.joint_budget.DataTypes.ShoppingListItem;

public interface ShopListPresenterInterface {
    void addShoplistItem();

    void editShoplistItem(ShoppingListItem item);

    void deleteShoplistItem(ShoppingListItem item);

    void loadItems();

    void setEvent(Bundle bundle);

    void getCurrentUser(Bundle bundle);

    String getUserID();
}
