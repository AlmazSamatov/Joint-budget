package joint_budget.joint_budget.API;

import java.util.LinkedList;
import java.util.List;

import joint_budget.joint_budget.DataTypes.Debt;


public abstract class DebtsAPI {

    public DebtsAPI() {

    }

    public void getAllDebts(LoadDebtsCallback callback) {
        // TODO implement me
    }

    public void sendInvoice(String debtID) {
        // TODO implement me
    }


    public void markAsReturned(String debtID) {
        // TODO implement me
    }

    protected interface LoadDebtsCallback{
        void onLoad(List<Debt> events);
    }
}

