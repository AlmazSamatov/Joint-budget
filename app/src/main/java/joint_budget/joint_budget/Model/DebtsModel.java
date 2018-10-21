package joint_budget.joint_budget.Model;

import java.util.ArrayList;
import java.util.List;

import joint_budget.joint_budget.API.DebtsAPI;
import joint_budget.joint_budget.API.FIrebaseAPI.FirebaseDebtsAPI;
import joint_budget.joint_budget.DataTypes.Currency;
import joint_budget.joint_budget.DataTypes.Debt;
import joint_budget.joint_budget.DataTypes.Purchase;
import joint_budget.joint_budget.DataTypes.PurchaseItem;
import joint_budget.joint_budget.DataTypes.UserInfo;

public class DebtsModel {

    private List<Debt> debts;
    private static volatile DebtsModel instance;
    private static volatile DebtsAPI debtsAPI;

    public static DebtsModel getInstance() {
        DebtsModel localInstance = instance;
        if (localInstance == null) {
            synchronized (DebtsModel.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DebtsModel();
                    debtsAPI = new FirebaseDebtsAPI();
                }
            }
        }
        return localInstance;
    }

    private DebtsModel(){
        debts = new ArrayList<>();
        debtsAPI = new FirebaseDebtsAPI();
    }

    public void addDebt(Debt debt) {
        debts.add(debt);
        debtsAPI.createDebt(debt);
    }

    public void deleteDebt(String debtID) {
        deleteDebtFromLocal(debtID);
        debtsAPI.markAsReturned(debtID);
    }

    private void deleteDebtFromLocal(String debtID) {
        for(int i = 0; i < debts.size(); i++){
            if(debts.get(i).getDebtID().equals(debtID)){
                debts.remove(i);
                break;
            }
        }
    }

    public void updateDebts(Purchase purchase) {
        List<Debt> debtsToDelete = new ArrayList<>(debts);

        for (Debt currentDebt : debtsToDelete) {
            if (currentDebt.getPurchaseID().equals(purchase.getPurchaseID())) {
                deleteDebt(currentDebt.getDebtID());
            }
        }
        calculateDebts(purchase);
    }

    public void deleteDebts(Purchase purchase) {

        List<Debt> debtsToDelete = new ArrayList<>(debts);

        for (Debt currentDebt : debtsToDelete) {
            if (currentDebt.getPurchaseID().equals(purchase.getPurchaseID())) {
                deleteDebt(currentDebt.getDebtID());
            }
        }
    }

    public void calculateDebts(Purchase purchase) {
        List<PurchaseItem> purchaseItems = purchase.getPurchaseItems();
        for (int i = 0; i < purchaseItems.size(); i++) {
            PurchaseItem currentItem = purchaseItems.get(i);
            itemToDebt(currentItem, purchase.getCurrency(), purchase.getEventID(), purchase.getPurchaseID());
        }
    }

    private void itemToDebt(PurchaseItem purchaseItem, Currency currency, String eventID, String purchaseID) {
        UserInfo creditor = purchaseItem.getParticipantsOfPurchase().get(0);
        for (int j = 1; j < purchaseItem.getParticipantsOfPurchase().size(); j++) {
            UserInfo currentParticipant = purchaseItem.getParticipantsOfPurchase().get(j);
            Debt debt = new Debt();
            debt.setCreditor(creditor);
            debt.setDebtor(currentParticipant);
            debt.setAmountOfDebt(purchaseItem.getCostOfPurchase() / purchaseItem.getParticipantsOfPurchase().size());
            debt.setCurrency(currency);
            debt.setEventID(eventID);
            debt.setPurchaseID(purchaseID);
            String key = debtsAPI.createDebt(debt);
            debt.setDebtID(key);
            debts.add(debt);
        }

    }

    public void getDebts(String userID, String eventID, DebtsAPI.LoadDebtsCallback callback) {
        debtsAPI.getAllDebts(callback, userID, eventID);
    }

    public void setDebts(List<Debt> debts){
        this.debts = debts;
    }

}
