package joint_budget.joint_budget.Login;

import joint_budget.joint_budget.DataTypes.UserInfo;

public interface LoginPresenterInterface {
    void login(String login, String password);
    void loginGoogle(String login, String password);

    void register(UserInfo userInfo);
    void resetPassword(String email);
}
