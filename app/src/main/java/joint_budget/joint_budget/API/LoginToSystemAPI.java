package joint_budget.joint_budget.API;


import joint_budget.joint_budget.DataTypes.LoginPage;
import joint_budget.joint_budget.DataTypes.RegisterPage;
import joint_budget.joint_budget.DataTypes.recoveryPage;

public abstract class LoginToSystemAPI {

    public LoginToSystemAPI() {
        //
    }


    public boolean login(LoginPage loginPage) {
        // TODO implement me
        return false;
    }


    public boolean register(RegisterPage registerPage) {
        // TODO implement me
        return false;
    }


    public boolean recoverAccount(recoveryPage recoveringPage) {
        // TODO implement me
        return false;
    }


    public LoginPage getSavedLogPass() {
        // TODO implement me
        return null;
    }

}

