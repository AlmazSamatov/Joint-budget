package joint_budget.joint_budget.Event.Debts;

import android.os.Bundle;

import java.util.List;

import joint_budget.joint_budget.API.DebtsAPI;
import joint_budget.joint_budget.DataTypes.Debt;
import joint_budget.joint_budget.Model.DebtsModel;

public class DebtsPresenter implements DebtsPresenterInterface {

    DebtsView view;
    private String userID;
    private String eventID;
    private DebtsModel debtsModel;

    DebtsPresenter(DebtsView view){
        this.view = view;
        debtsModel = DebtsModel.getInstance();
    }

    @Override
    public void loadDebts() {
        view.turnOnProgressBar();
        debtsModel.getDebts(userID, eventID, new DebtsAPI.LoadDebtsCallback() {
            @Override
            public void onLoad(List<Debt> debts) {
                view.turnOffProgressBar();
                debtsModel.setDebts(debts);
                view.showDebts(debts);
            }
        });
    }

    @Override
    public void deleteDebt(Debt debt) {
        debtsModel.deleteDebt(debt.getDebtID());
        view.updateListView();
    }

    @Override
    public void getCurrentUser(Bundle bundle) {
        if(bundle != null) {
            userID = bundle.getString("userID");
            eventID = bundle.getString("eventID");
        }
    }

    @Override
    public String getUserID() {
        return userID;
    }
}
