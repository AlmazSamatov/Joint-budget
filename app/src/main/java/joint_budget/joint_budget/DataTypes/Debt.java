package joint_budget.joint_budget.DataTypes;

public class Debt {
    private boolean amIOwe;
    private UserInfo debtParticipant;
    private int amountOfDebt;
    private Currency currency;

    Debt() {
    }

    public boolean isAmIOwe() {
        return amIOwe;
    }

    public void setAmIOwe(boolean amIOwe) {
        this.amIOwe = amIOwe;
    }

    public UserInfo getDebtParticipant() {
        return debtParticipant;
    }

    public void setDebtParticipant(UserInfo debtParticipant) {
        this.debtParticipant = debtParticipant;
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

}
