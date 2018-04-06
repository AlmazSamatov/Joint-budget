package joint_budget.joint_budget.DataTypes;

import java.util.LinkedList;

public class Purchase {
    private LinkedList<PurchaseItem> purchaseItems;
    private Currency currency;
    private int totalCost;
    private String purchaseName;

    public LinkedList<PurchaseItem> getPurchaseItems() {
        return purchaseItems;
    }

    public void setPurchaseItems(LinkedList<PurchaseItem> purchaseItems) {
        this.purchaseItems = purchaseItems;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public String getPurchaseName() {
        return purchaseName;
    }

    public void setPurchaseName(String purchaseName) {
        this.purchaseName = purchaseName;
    }
}
