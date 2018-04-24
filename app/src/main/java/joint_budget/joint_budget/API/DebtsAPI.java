package joint_budget.joint_budget.API;

import java.util.List;

import joint_budget.joint_budget.DataTypes.Debt;


public interface DebtsAPI {


    void getAllDebts(LoadDebtsCallback callback, String userID);

    void getAllDebtsThatIowe(LoadDebtsCallback callback, String userID);

    void getAllDebtsThatOwedToMe(LoadDebtsCallback callback, String userID);

    void sendInvoice(String debtID);

    void markAsReturned(String debtID);

    String createDebt(Debt debt);

    interface LoadDebtsCallback {
        void onLoad(List<Debt> debts);
    }
}

