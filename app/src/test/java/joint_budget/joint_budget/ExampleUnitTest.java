package joint_budget.joint_budget;

import com.google.firebase.auth.FirebaseUser;

import org.junit.Test;

import joint_budget.joint_budget.API.FIrebaseAPI.FirebaseLoginToSystem;
import joint_budget.joint_budget.DataTypes.User;

import static org.junit.Assert.assertEquals;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws InterruptedException {
        FirebaseLoginToSystem api = new FirebaseLoginToSystem();

        FirebaseUser user = api.register(new User());
        assertEquals("dilschat@yandex.ru", user.getEmail());
    }
}