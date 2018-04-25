package joint_budget.joint_budget.DataTypes;

import java.util.List;

public class PurchaseItem {
    private String itemName;
    private Currency costOfPurchase;
    private List<UserInfo> participantsOfPurchase;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) { this.itemName = itemName; }

    public Currency getCostOfPurchase() {
        return costOfPurchase;
    }

    public void setCostOfPurchase(Currency costOfPurchase) {
        this.costOfPurchase = costOfPurchase;
    }

    public List<UserInfo> getParticipantsOfPurchase() {
        return participantsOfPurchase;
    }

    public void setParticipantsOfPurchase(List<UserInfo> participantsOfPurchase) {
        this.participantsOfPurchase = participantsOfPurchase;
    }
}
