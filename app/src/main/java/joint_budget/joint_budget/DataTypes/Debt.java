package joint_budget.joint_budget.DataTypes;

public class Debt {
    private UserInfo creditor;
    private UserInfo debtor;
    private double amountOfDebt;
    private Currency currency;
    private String debtID;
    private String eventID;
    private String purchaseID;

    public Debt() {
    }

    public double getAmountOfDebt() {
        return amountOfDebt;
    }

    public void setAmountOfDebt(double amountOfDebt) {
        this.amountOfDebt = amountOfDebt;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public UserInfo getCreditor() {
        return creditor;
    }

    public void setCreditor(UserInfo creditor) {
        this.creditor = creditor;
    }

    public UserInfo getDebtor() {
        return debtor;
    }

    public void setDebtor(UserInfo debtor) {
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

    public String getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(String purchaseID) {
        this.purchaseID = purchaseID;
    }
}
