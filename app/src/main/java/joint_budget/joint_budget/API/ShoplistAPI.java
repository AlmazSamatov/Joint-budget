package joint_budget.joint_budget.API;


import java.util.List;

import joint_budget.joint_budget.DataTypes.ShoppingListItem;

public interface ShoplistAPI {


    String addItem(String eventID, ShoppingListItem item);


    void deleteItem(String EventID, String ShoplstItemID);


    void editItem(String eventID, ShoppingListItem item);


    void getAllShops(ShoppingListCallBack callback);

    interface ShoppingListCallBack {
        void onLoad(List<ShoppingListItem> items);
    }


}

