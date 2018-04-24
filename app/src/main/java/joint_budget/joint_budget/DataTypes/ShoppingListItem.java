package joint_budget.joint_budget.DataTypes;

import io.realm.RealmModel;
import io.realm.RealmObject;

public class ShoppingListItem extends RealmObject implements RealmModel{
    private String name;
    private UserInfo buyer;
    private String itemID;

    public ShoppingListItem() {
    }

    public ShoppingListItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }
}
