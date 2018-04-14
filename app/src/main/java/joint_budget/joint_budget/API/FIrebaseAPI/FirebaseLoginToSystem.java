package joint_budget.joint_budget.API.FIrebaseAPI;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import joint_budget.joint_budget.API.LoginToSystemAPI;

public class FirebaseLoginToSystem extends LoginToSystemAPI {
    private FirebaseAuth mAuth;

    @Override
    public FirebaseUser register(RegisterPage registerPage) throws InterruptedException {
        mAuth = FirebaseAuth.getInstance();
        Task<AuthResult> task = mAuth.createUserWithEmailAndPassword(registerPage.getEmail(), registerPage.getPassword());
        while (task.isComplete()) {
            Thread.sleep(700);
        }
        if (task.isSuccessful()) {
            return mAuth.getCurrentUser();
        } else {
            return null;
        }

    }
}
