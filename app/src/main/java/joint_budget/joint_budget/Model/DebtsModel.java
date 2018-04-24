package joint_budget.joint_budget.Model;

import joint_budget.joint_budget.API.DebtsAPI;
import joint_budget.joint_budget.API.FIrebaseAPI.FireBaseDebtsAPI;

public class DebtsModel {

    private static volatile DebtsModel instance;
    private static volatile DebtsAPI debtsAPI;

    public static DebtsModel getInstance() {
        DebtsModel localInstance = instance;
        if (localInstance == null) {
            synchronized (DebtsModel.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DebtsModel();
                    debtsAPI = new FireBaseDebtsAPI();
                }
            }
        }
        return localInstance;
    }

    private DebtsModel(){}

}
