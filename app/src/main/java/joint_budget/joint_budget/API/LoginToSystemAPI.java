package joint_budget.joint_budget.API;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;

public abstract class LoginToSystemAPI<T> {

    private FirebaseAuth mAuth;

    public LoginToSystemAPI() {
        //
    }

    public abstract FirebaseUser login(String login, String password) throws InterruptedException;


    public T register(UserInfo userInfo, String password) throws InterruptedException {
        return null;
    }


    public boolean recoverAccount() {
        // TODO implement me
        return false;
    }


    public UserInfo getSavedLogPass() {
        // TODO implement me
        return null;
    }

}

