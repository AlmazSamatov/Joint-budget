package joint_budget.joint_budget.DataTypes;

import com.google.firebase.auth.FirebaseUser;

import java.util.LinkedList;

public class PurchaseItem {
    private String itemName;
    private Currency costOfPurchase;
    private LinkedList<FirebaseUser> participantsOfPurchase;

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

    public LinkedList<FirebaseUser> getParticipantsOfPurchase() {
        return participantsOfPurchase;
    }

    public void setParticipantsOfPurchase(LinkedList<FirebaseUser> participantsOfPurchase) {
        this.participantsOfPurchase = participantsOfPurchase;
    }
}
