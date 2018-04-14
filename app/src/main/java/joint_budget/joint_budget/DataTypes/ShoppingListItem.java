package joint_budget.joint_budget.DataTypes;

public class ShoppingListItem {
    private String name;
    private UserInfo buyer;

    public ShoppingListItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
