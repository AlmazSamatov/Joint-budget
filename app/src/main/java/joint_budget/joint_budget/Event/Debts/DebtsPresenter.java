package joint_budget.joint_budget.Event.Debts;

public class DebtsPresenter implements DebtsPresenterInterface {

    DebtsView view;

    DebtsPresenter(){
        view = new DebtsActivity();
    }
}
