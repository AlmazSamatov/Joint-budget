package joint_budget.joint_budget.DataTypes;

public class ShoppingListItem {
    private String name;
    private UserInfo buyer;

    private String itemID;

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
