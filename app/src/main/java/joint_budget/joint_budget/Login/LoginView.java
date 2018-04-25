package joint_budget.joint_budget.Login;

interface LoginView {
    void launchEventsActivity(String userID);

    void turnOffProgressBar();

    void turnOnProgressBar();

    void showError(String s);
}
