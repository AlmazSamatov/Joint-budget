package joint_budget.joint_budget.API;

import java.util.LinkedList;

import joint_budget.joint_budget.DataTypes.Debt;


public abstract class DebtsAPI {

    public DebtsAPI() {

    }


    public LinkedList<Debt> getAllDebts() {
        // TODO implement me
        return new LinkedList<>();
    }


    public void sendInvoice(String debtID) {
        // TODO implement me
    }


    public void markAsReturned(String debtID) {
        // TODO implement me
    }


}

