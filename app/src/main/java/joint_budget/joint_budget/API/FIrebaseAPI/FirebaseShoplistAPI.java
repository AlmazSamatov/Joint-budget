package joint_budget.joint_budget.API.FIrebaseAPI;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import joint_budget.joint_budget.API.ShoplistAPI;

public class FirebaseShoplistAPI extends ShoplistAPI {

    FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private DatabaseReference referenceToShopList;

    public FirebaseShoplistAPI() {
        firebaseDatabase = FirebaseDatabase.getInstance("https://joint-budget-f59f7.firebaseio.com/");
        databaseReference = firebaseDatabase.getReference();
        referenceToShopList = databaseReference.child("shoplist");
    }

    @Override
    public void addItem() {
        super.addItem();
    }

    @Override
    public void deleteItem() {
        super.deleteItem();
    }

    @Override
    public void editItem() {
        super.editItem();
    }

    @Override
    public void getAllShops() {
        super.getAllShops();
    }

    @Override
    public void subscribeToItemsUpdates() {
        super.subscribeToItemsUpdates();
    }
}
