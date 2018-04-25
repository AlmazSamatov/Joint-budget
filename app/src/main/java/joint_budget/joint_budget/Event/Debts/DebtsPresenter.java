package joint_budget.joint_budget.Event.Debts;

import android.content.Intent;

import joint_budget.joint_budget.DataTypes.Debt;

public class DebtsPresenter implements DebtsPresenterInterface {

    DebtsView view;
    private String userID;

    DebtsPresenter(DebtsView view){
        this.view = view;
    }

    @Override
    public void loadDebts() {

    }

    @Override
    public void deleteDebt(Debt debt) {
        /*if(debt.getDebtParticipant1() == currentUser.getUserID()){

            // delete from model
        }*/
    }

    @Override
    public void getCurrentUser(Intent intent) {
        userID = intent.getStringExtra("userID");
    }

    @Override
    public String getUserID() {
        return userID;
    }
}
