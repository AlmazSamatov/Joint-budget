package joint_budget.joint_budget.DataTypes;

public class Debt {
    private String debtParticipant1;
    private String debtParticipant2;
    private int amountOfDebt;
    private Currency currency;

    Debt() {
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
