package joint_budget.joint_budget.API.FIrebaseAPI;

import java.util.LinkedList;

import joint_budget.joint_budget.API.DebtsAPI;
import joint_budget.joint_budget.DataTypes.Debt;

public class FireBaseDebtsAPI implements DebtsAPI {
    @Override
    public LinkedList<Debt> getAllDebts() {
        return null;
    }

    @Override
    public void sendInvoice(String debtID) {

    }

    @Override
    public void markAsReturned(String debtID) {

    }


}
