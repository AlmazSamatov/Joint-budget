package joint_budget.joint_budget.DataTypes;

import java.util.ArrayList;
import java.util.Date;

public class Event {
    private String name;
    private Date startDate;
    private Date endDate;
    private Currency currency;
    private ArrayList<User> participants;
    private String eventId;


    public Event() {

    }
    public Event(String name, Date startDate, Date endDate, Currency currency, ArrayList<User> participants) {
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

    public ArrayList<User> getParticipants() {
        return participants;
    }

    public void setParticipants(ArrayList<User> participants) {
        this.participants = participants;
    }

    public void setEventId(String key) {
        eventId = key;
    }

    public String getEventId() {
        return eventId;
    }

}
