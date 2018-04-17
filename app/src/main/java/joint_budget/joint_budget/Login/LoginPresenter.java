package joint_budget.joint_budget.Login;

import joint_budget.joint_budget.DataTypes.UserInfo;

public class LoginPresenter implements LoginPresenterInterface {

    LoginView view;

    LoginPresenter(){
        view = new LoginActivity();
    }

    @Override
    public void login(String login, String password) {

    }

    @Override
    public void loginGoogle(String login, String password) {

    }

    @Override
    public void resetPassword(String email) {

    }
}
