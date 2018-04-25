package joint_budget.joint_budget.DataTypes;

public class Debt {
    private String creditor;
    private String debtor;
    private int amountOfDebt;
    private Currency currency;
    private String debtID;
    private String eventID;

    public Debt() {
    }

    public int getAmountOfDebt() {
        return amountOfDebt;
    }

    public void setAmountOfDebt(int amountOfDebt) {
        this.amountOfDebt = amountOfDebt;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getCreditor() {
        return creditor;
    }

    public void setCreditor(String creditor) {
        this.creditor = creditor;
    }

    public String getDebtor() {
        return debtor;
    }

    public void setDebtor(String debtor) {
        this.debtor = debtor;
    }

    public String getDebtID() {
        return debtID;
    }

    public void setDebtID(String debtID) {
        this.debtID = debtID;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }


}
