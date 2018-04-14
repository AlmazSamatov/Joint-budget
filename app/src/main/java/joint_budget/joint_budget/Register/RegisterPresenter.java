package joint_budget.joint_budget.Register;

import joint_budget.joint_budget.DataTypes.UserInfo;

public class RegisterPresenter implements RegisterPresenterInterface {

    RegisterView view;

    RegisterPresenter(){
        view = new RegisterActivity();
    }

    @Override
    public void register(UserInfo userInfo) {

    }
}
