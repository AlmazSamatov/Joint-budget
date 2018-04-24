package joint_budget.joint_budget.Event.ShopList;

import joint_budget.joint_budget.DataTypes.ShoppingListItem;

interface ShopListView {

    void delete(ShoppingListItem item);
    void edit(ShoppingListItem item);
}
