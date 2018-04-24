package joint_budget.joint_budget.Event.ShopList;

import android.content.Intent;

import joint_budget.joint_budget.DataTypes.ShoppingListItem;

public interface ShopListPresenterInterface {
    void addShoplistItem(ShoppingListItem purchase);

    void editShoplistItem(ShoppingListItem purchase);

    void deleteShoplistItem(ShoppingListItem purchase);

    void setEvent(Intent intent);

}
