package joint_budget.joint_budget.DataTypes;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Event {
    private String name;
    private Date startDate;
    private Date endDate;
    private Currency currency;
    private List<UserInfo> participants;
    private HashMap<String, Purchase> purchases;
    private String eventId;
    private List<ShoppingListItem> shopList;
    private String password;

    public Event() {
    }

    public Event(String name, Date startDate, Date endDate, Currency currency, ArrayList<UserInfo> participants) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.currency = currency;
        this.participants = participants;
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
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public List<UserInfo> getParticipants() {
        return participants;
    }

    public void setParticipants(List<UserInfo> participants) {
        this.participants = participants;
    }

    public void setEventId(String key) {
        eventId = key;
    }

    public String getEventId() {
        return eventId;
    }

    public List<ShoppingListItem> getShopList() {
        return shopList;
    }

    public void setShopList(List<ShoppingListItem> shopList) {
        this.shopList = shopList;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HashMap<String, Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(HashMap<String, Purchase> purchases) {
        this.purchases = purchases;
    }
}
