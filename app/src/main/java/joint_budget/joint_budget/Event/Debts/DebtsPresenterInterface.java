package joint_budget.joint_budget.Event.Debts;

import android.os.Bundle;

import joint_budget.joint_budget.DataTypes.Debt;

public interface DebtsPresenterInterface {
    void loadDebts();
    void deleteDebt(Debt debt);

    void getCurrentUser(Bundle bundle);

    String getUserID();
}
