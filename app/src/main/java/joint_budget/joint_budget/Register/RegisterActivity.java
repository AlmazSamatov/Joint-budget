package joint_budget.joint_budget.Register;

public class RegisterActivity implements RegisterView {

    RegisterPresenterInterface presenter;

    RegisterActivity(){
        presenter = new RegisterPresenter();
    }
}
