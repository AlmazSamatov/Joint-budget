package joint_budget.joint_budget.API;

import java.util.List;

import joint_budget.joint_budget.DataTypes.PrivateUserInfo;

public interface LoginToSystemAPI<T> {

    void login(String email, String password, LoginCallback callback);

    void register(PrivateUserInfo user, RegisterCallback callback) throws InterruptedException;

    void recoverAccount(String email, final LoginCallback callback);

    String getSavedLogPass();

    interface LoginCallback {
        void onLogin(List<PrivateUserInfo> account);
    }

    interface RegisterCallback {
        void onRegister(String userID);
    }

    interface GetUserCallback{
        void onLoad(List<PrivateUserInfo> userInfos);
    }
}

