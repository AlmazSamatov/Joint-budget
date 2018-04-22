package joint_budget.joint_budget.DataTypes;

import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.LinkedList;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;

public class PurchaseItem extends RealmObject{
    private String itemName;
    private Double costOfPurchase;
    @Ignore
    private LinkedList<FirebaseUser> participantsOfPurchase;
    private RealmList<UserInfo> participants;

    /*
    *   Warning: for each constructor define initialization of participants list!!!
    * */
    public PurchaseItem() {
        participants = new RealmList<>();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getCostOfPurchase() {
        return costOfPurchase;
    }

    public void setCostOfPurchase(Double costOfPurchase) {
        this.costOfPurchase = costOfPurchase;
    }

    public LinkedList<FirebaseUser> getParticipantsOfPurchase() {
        return participantsOfPurchase;
    }

    public void setParticipantsOfPurchase(LinkedList<FirebaseUser> participantsOfPurchase) {
        this.participantsOfPurchase = participantsOfPurchase;
    }

    public ArrayList<UserInfo> getParticipants() {
        return new ArrayList<>(participants);
    }

    public void setParticipants(ArrayList<UserInfo> participants) {
        this.participants.clear();
        this.participants.addAll(participants);
    }
}
