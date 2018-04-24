package joint_budget.joint_budget.DataTypes;

import java.util.LinkedList;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmModel;
import io.realm.RealmObject;

public class Purchase extends RealmObject implements RealmModel{
    private RealmList<PurchaseItem> purchaseItems; // Leave it as RealmList; getters and setters operate with LinkedList
    private String currency; // Leave it as a String; anyhow, getters and setters operate with Currency
    private double totalCost;
    private String purchaseName;
    private String purchaseID;
    private String eventID;
    private String eventName;

    /*
     *   Warning: for each constructor define initialization of purchaseItems list!!!
     * */
    public Purchase() {
        purchaseItems = new RealmList<>();
    }

    public LinkedList<PurchaseItem> getPurchaseItems() {
        return new LinkedList<>(purchaseItems);
    }

    public void setPurchaseItems(LinkedList<PurchaseItem> purchaseItems) {
        this.purchaseItems.clear();
        this.purchaseItems.addAll(purchaseItems);
    }

    public Currency getCurrency() {
        return Currency.valueOf(currency);
    }

    public void setCurrency(Currency currency) {
        this.currency = currency.toString();
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getPurchaseName() {
        return purchaseName;
    }

    public void setPurchaseName(String purchaseName) {
        this.purchaseName = purchaseName;
    }

    public String getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(String purchaseID) {
        this.purchaseID = purchaseID;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public void setPurchaseItems(RealmList<PurchaseItem> purchaseItems) {
        this.purchaseItems = purchaseItems;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
