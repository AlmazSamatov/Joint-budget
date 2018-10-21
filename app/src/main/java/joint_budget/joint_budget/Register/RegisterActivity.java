package joint_budget.joint_budget.Register;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import joint_budget.joint_budget.DataTypes.PrivateUserInfo;
import joint_budget.joint_budget.Events.Events.EventsActivity;
import joint_budget.joint_budget.R;

public class RegisterActivity extends AppCompatActivity implements RegisterView {

    RegisterPresenterInterface presenter;
    @BindView(R.id.firstname)
    TextInputEditText firstname;
    @BindView(R.id.lastname)
    TextInputEditText lastname;
    @BindView(R.id.username)
    TextInputEditText username;
    @BindView(R.id.phone_number)
    TextInputEditText phoneNumber;
    @BindView(R.id.email)
    TextInputEditText email;
    @BindView(R.id.credit_card)
    TextInputEditText creditCard;
    @BindView(R.id.new_password)
    TextInputEditText password1;
    @BindView(R.id.repeat_password)
    TextInputEditText password2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        presenter = new RegisterPresenter(this, getApplicationContext());
    }

    public void createAccount(View view) {
        if(firstname.getText().toString().trim().length() == 0){
            showError("Type firstname");
        } else if(lastname.getText().toString().trim().length() == 0){
            showError("Type lastname");
        } else if(username.getText().toString().trim().length() == 0){
            showError("Type username");
        } else if(email.getText().toString().trim().length() == 0){
            showError("Type email");
        } else if(password1.getText().toString().trim().length() == 0){
            showError("Type password");
        } else if(password2.getText().toString().trim().length() == 0){
            showError("Reenter password");
        } else if(!password1.getText().toString().equals(password2.getText().toString())) {
            showError("Passwords are different");
        } else{
            PrivateUserInfo userInfo = new PrivateUserInfo();
            userInfo.setUserName(username.getText().toString());
            userInfo.setFirstName(firstname.getText().toString());
            userInfo.setLastName(lastname.getText().toString());
            userInfo.setEmail(email.getText().toString());
            userInfo.setPhoneNumber(phoneNumber.getText().toString());
            userInfo.setPassword(password1.getText().toString());
            presenter.register(userInfo);
        }
    }

    @Override
    public void launchEventsActivity(String userID) {
        Intent intent = new Intent(getBaseContext(), EventsActivity.class);
        intent.putExtra("userID", userID);
        startActivity(intent);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}
