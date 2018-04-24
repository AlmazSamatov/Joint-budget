package joint_budget.joint_budget.DataTypes;

import io.realm.RealmModel;
import io.realm.RealmObject;

public class Debt extends RealmObject implements RealmModel{
    private String debtParticipant1;
    private String debtParticipant2;
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

    public String getDebtParticipant1() {
        return debtParticipant1;
    }

    public void setDebtParticipant1(String debtParticipant1) {
        this.debtParticipant1 = debtParticipant1;
    }

    public String getDebtParticipant2() {
        return debtParticipant2;
    }

    public void setDebtParticipant2(String debtParticipant2) {
        this.debtParticipant2 = debtParticipant2;
    }

}
