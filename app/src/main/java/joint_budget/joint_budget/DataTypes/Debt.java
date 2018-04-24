package joint_budget.joint_budget.DataTypes;

import io.realm.RealmModel;
import io.realm.RealmObject;

public class Debt extends RealmObject implements RealmModel{
    private String creditor;
    private String debtor;
    private double amountOfDebt;
    private String currency; // Leave it as a String; anyhow, getters and setters operate with Currency

    public Debt() {
    }

    public double getAmountOfDebt() {
        return amountOfDebt;
    }

    public void setAmountOfDebt(int amountOfDebt) {
        this.amountOfDebt = amountOfDebt;
    }

    public Currency getCurrency() {
        return Currency.valueOf(currency);
    }

    public void setCurrency(Currency currency) {
        this.currency = currency.toString();
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

}
