package joint_budget.joint_budget.LoginRegister;

import joint_budget.joint_budget.DataTypes.User;

public interface LoginRegisterPresenter {
    void login(String login, String password);
    void loginGoogle(String login, String password);
    void register(User user);
    void resetPassword(String email);
}
