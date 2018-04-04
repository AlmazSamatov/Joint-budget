package joint_budget.joint_budget.DataTypes;

import java.util.ArrayList;

public class Event {
    private String name;
    private String startDate;
    private String endDate;
    private String currency;
    private ArrayList<User> participants;

    public Event(String name, String startDate, String endDate, String currency, ArrayList<User> participants) {
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public ArrayList<User> getParticipants() {
        return participants;
    }

    public void setParticipants(ArrayList<User> participants) {
        this.participants = participants;
    }
}
