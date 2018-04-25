package joint_budget.joint_budget.DataTypes;


public class PrivateUserInfo extends UserInfo {

    private String password;
    private String cvv;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
