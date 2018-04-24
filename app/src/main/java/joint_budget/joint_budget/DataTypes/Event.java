package joint_budget.joint_budget.DataTypes;

import java.util.ArrayList;
import java.util.Date;

import io.realm.RealmList;
import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.annotations.Required;

public class Event extends RealmObject implements RealmModel{
    @Required
    private String name;
    private String eventId;
    private String password;
    private Date startDate;
    private Date endDate;

    private String currency; // Leave it as a String; anyhow, getters and setters operate with Currency
    private RealmList<UserInfo> participants; // Leave it as RealmList; getters and setters operate with ArrayList
    private RealmList<ShoppingListItem> shopList; // Leave it as RealmList; getters and setters operate with ArrayList
    private RealmList<Purchase> purchases; // Leave it as RealmList; getters and setters operate with ArrayList
    private RealmList<Debt> debts; // Leave it as RealmList; getters and setters operate with ArrayList

    public Event() {
        participants = new RealmList<>();
        shopList = new RealmList<>();
        purchases = new RealmList<>();
        debts = new RealmList<>();
    }

    public Event(String eventId, String password, String name, Date startDate, Date endDate, String currency, ArrayList<UserInfo> participants, ArrayList<ShoppingListItem> shopList, ArrayList<Purchase> purchases, ArrayList<Debt> debts) {
        this.eventId = eventId;
        this.password = password;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.currency = Currency.valueOf(currency).toString();

        this.participants = new RealmList<>();
        this.participants.addAll(participants);

        this.shopList = new RealmList<>();
        this.shopList.addAll(shopList);

        this.purchases = new RealmList<>();
        this.purchases.addAll(purchases);

        this.debts = new RealmList<>();
        this.debts.addAll(debts);
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Currency getCurrency() {
        return Currency.valueOf(this.currency);
    }

    public void setCurrency(Currency currency) {
        this.currency = currency.toString();
    }

    public void setCurrency(String currency) {
        this.currency = Currency.valueOf(currency).toString();
    }

    public ArrayList<UserInfo> getParticipants() {
        return new ArrayList<>(participants);
    }

    public void setParticipants(ArrayList<UserInfo> participants) {
        this.participants.clear();
        this.participants.addAll(participants);
    }

    public ArrayList<ShoppingListItem> getShopList() {
        return new ArrayList<>(shopList);
    }

    public void setShopList(ArrayList<ShoppingListItem> shopList) {
        this.shopList.clear();
        this.shopList.addAll(shopList);
    }

    public ArrayList<Purchase> getPurchases() {
        return new ArrayList<>(purchases);
    }

    public void setPurchases(ArrayList<Purchase> purchases) {
        this.purchases.clear();
        this.purchases.addAll(purchases);
    }

    public ArrayList<Debt> getDebts() {
        return new ArrayList<>(debts);
    }

    public void setDebts(ArrayList<Debt> debts) {
        this.debts.clear();
        this.debts.addAll(debts);
    }
}
