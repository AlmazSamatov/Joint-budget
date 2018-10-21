package joint_budget.joint_budget.DataTypes;

public class UserInfo {
    private String firstName;
    private String lastName;
    private String userName;
    private String phoneNumber;
    private String email;
    private String creditCard;
    private String userID;


    public UserInfo() {
    }

    public UserInfo(String firstName, String lastName, String userName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;

    }

    public UserInfo(String firstName, String lastName, String userName, String phoneNumber, String email, String creditCard, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.creditCard = creditCard;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public boolean equals(UserInfo userInfo) {
        if(this.getUserID() != null && userInfo.getUserID() != null){
            return this.getUserID().equals(userInfo.getUserID());
        } else{
            return this.getUserName().equals(userInfo.getUserName());
        }
    }
}
