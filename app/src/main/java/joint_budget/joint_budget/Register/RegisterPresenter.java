package joint_budget.joint_budget.Register;

import joint_budget.joint_budget.DataTypes.UserInfo;

public class RegisterPresenter implements RegisterPresenterInterface {

    RegisterView view;

    RegisterPresenter(RegisterView view){
        this.view = view;
    }

    @Override
    public void register(UserInfo userInfo) {

    }
}
