package joint_budget.joint_budget.API;


import com.google.firebase.auth.FirebaseAuth;

public abstract class LoginToSystemAPI<T> {

    private FirebaseAuth mAuth;

    public LoginToSystemAPI() {
        //
    }


    public boolean login(LoginPage loginPage) {
        // TODO implement me
        return false;
    }


    public T register(RegisterPage registerPage) throws InterruptedException {
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

