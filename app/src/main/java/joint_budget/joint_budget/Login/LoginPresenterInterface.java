package joint_budget.joint_budget.Login;

public interface LoginPresenterInterface {
    void login(String login, String password);
    void loginGoogle(String login, String password);

    void resetPassword(String email);

    void checkLoggedIn();
}
