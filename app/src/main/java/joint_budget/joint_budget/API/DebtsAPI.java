package joint_budget.joint_budget.API;

import java.util.List;

import joint_budget.joint_budget.DataTypes.Debt;


public interface DebtsAPI {


    void getAllDebts(LoadDebtsCallback callback, String userID,String eventID);

    void getAllDebtsThatIowe(LoadDebtsCallback callback, String userID,String eventID);

    void getAllDebtsThatOwedToMe(LoadDebtsCallback callback, String userID, String eventID);

    void sendInvoice(String debtID);

    void markAsReturned(String debtID);

    String createDebt(Debt debt);

    interface LoadDebtsCallback {
        void onLoad(List<Debt> debts);
    }
}

