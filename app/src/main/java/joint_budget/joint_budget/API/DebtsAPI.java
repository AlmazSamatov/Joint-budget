package joint_budget.joint_budget.API;

import java.util.LinkedList;

import joint_budget.joint_budget.DataTypes.Debt;


public interface DebtsAPI {


    LinkedList<Debt> getAllDebts();


    void sendInvoice(String debtID);


    void markAsReturned(String debtID);



}

