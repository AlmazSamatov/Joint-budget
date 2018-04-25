package joint_budget.joint_budget.Event.Debts;

import java.util.List;

import joint_budget.joint_budget.DataTypes.Debt;

interface DebtsView {
    void showDebts(List<Debt> debts);
    void updateListView();
}
