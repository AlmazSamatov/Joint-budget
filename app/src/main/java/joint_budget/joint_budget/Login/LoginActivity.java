package joint_budget.joint_budget.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import joint_budget.joint_budget.Events.Events.EventsActivity;
import joint_budget.joint_budget.R;
import joint_budget.joint_budget.Register.RegisterActivity;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements LoginView {

    LoginPresenterInterface presenter;
    @BindView(R.id.email)
    AutoCompleteTextView email;
    @BindView(R.id.password)
    TextInputEditText password;
    @BindView(R.id.login_progress)
    ProgressBar progressBar;
    @BindView(R.id.login_form)
    ScrollView loginForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialize();
    }

    private void initialize() {
        ButterKnife.bind(this);
        presenter = new LoginPresenter(this, getApplicationContext());
        presenter.checkLoggedIn();
    }

    @Override
    public void launchEventsActivity(String userID){
        Intent intent = new Intent(getBaseContext(), EventsActivity.class);
        intent.putExtra("userID", userID);
        startActivity(intent);
    }

    @Override
    public void turnOffProgressBar(){
        progressBar.setVisibility(View.GONE);
        loginForm.setVisibility(View.VISIBLE);
    }

    @Override
    public void turnOnProgressBar(){
        loginForm.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }


    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    public void loginOnClick(View view) {
        turnOnProgressBar();
        presenter.login(email.getText().toString(), password.getText().toString());
    }

    public void registerOnClick(View view) {
        Intent intent = new Intent(getBaseContext(), RegisterActivity.class);
        startActivity(intent);
    }
}

