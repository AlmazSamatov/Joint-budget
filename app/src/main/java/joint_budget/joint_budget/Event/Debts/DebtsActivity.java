package joint_budget.joint_budget.Event.Debts;

public class DebtsActivity implements DebtsView {

    DebtsPresenterInterface presenter;

    DebtsActivity(){
        presenter = new DebtsPresenter();
    }
}
