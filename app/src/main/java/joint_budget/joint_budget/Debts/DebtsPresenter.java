package joint_budget.joint_budget.Debts;

public class DebtsPresenter implements DebtsPresenterInterface {

    DebtsView view;

    DebtsPresenter(){
        view = new DebtsActivity();
    }
}
