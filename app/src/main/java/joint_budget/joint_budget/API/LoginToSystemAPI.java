package joint_budget.joint_budget.API;


import com.google.firebase.auth.FirebaseAuth;

import joint_budget.joint_budget.DataTypes.LoginPage;
import joint_budget.joint_budget.DataTypes.User;
import joint_budget.joint_budget.DataTypes.recoveryPage;

public abstract class LoginToSystemAPI<T> {

    private FirebaseAuth mAuth;

    public LoginToSystemAPI() {
        //
    }


    public boolean login(LoginPage loginPage) {
        // TODO implement me
        return false;
    }


    public T register(User user) throws InterruptedException {
        return null;
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

