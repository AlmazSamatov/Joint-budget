package joint_budget.joint_budget.Event.Debts;

import joint_budget.joint_budget.DataTypes.Debt;
import joint_budget.joint_budget.DataTypes.UserInfo;

public class DebtsPresenter implements DebtsPresenterInterface {

    DebtsView view;
    private UserInfo currentUser;

    DebtsPresenter(DebtsView view){
        this.view = view;
        currentUser = new UserInfo();
        currentUser.setUserName("Ivan Ivanov");
    }

    @Override
    public void loadDebts() {

    }

    @Override
    public void deleteDebt(Debt debt) {
        if(debt.getDebtParticipant1() == currentUser.getUserID()){

            // delete from model
        }
    }
}
