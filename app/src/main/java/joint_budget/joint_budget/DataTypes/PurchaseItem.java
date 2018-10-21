package joint_budget.joint_budget.DataTypes;

import java.util.List;

public class PurchaseItem {
    private String itemName;
    private double costOfPurchase;
    private List<UserInfo> participantsOfPurchase;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) { this.itemName = itemName; }

    public double getCostOfPurchase() {
        return costOfPurchase;
    }

    public void setCostOfPurchase(double costOfPurchase) {
        this.costOfPurchase = costOfPurchase;
    }

    public List<UserInfo> getParticipantsOfPurchase() {
        return participantsOfPurchase;
    }

    public void setParticipantsOfPurchase(List<UserInfo> participantsOfPurchase) {
        this.participantsOfPurchase = participantsOfPurchase;
    }
}
