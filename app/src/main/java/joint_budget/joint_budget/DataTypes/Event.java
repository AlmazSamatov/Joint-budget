package joint_budget.joint_budget.DataTypes;

import java.util.ArrayList;
import java.util.Date;

import io.realm.RealmList;
import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.annotations.Required;

public class Event extends RealmObject implements RealmModel{
    private String eventId;
    private String password;
    @Required
    private String name;
    private Date startDate;
    private Date endDate;
    private String currency;
    private RealmList<UserInfo> participants;
    private RealmList<ShoppingListItem> shopList;

    public Event() {
        participants = new RealmList<>();
        shopList = new RealmList<>();
    }

    public Event(String eventId, String password, String name, Date startDate, Date endDate, String currency, ArrayList<UserInfo> participants, ArrayList<ShoppingListItem> shopList) {
        this.eventId = eventId;
        this.password = password;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.currency = Currency.valueOf(currency).toString();
        this.participants = new RealmList<>();
        this.shopList = new RealmList<>();
        this.participants.addAll(participants);
        this.shopList.addAll(shopList);
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

}
