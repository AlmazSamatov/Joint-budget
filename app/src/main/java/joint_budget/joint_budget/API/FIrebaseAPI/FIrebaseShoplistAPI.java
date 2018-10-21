package joint_budget.joint_budget.API.FIrebaseAPI;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import joint_budget.joint_budget.API.ShoplistAPI;
import joint_budget.joint_budget.DataTypes.ShoppingListItem;

public class FirebaseShoplistAPI implements ShoplistAPI {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    public FirebaseShoplistAPI() {
        firebaseDatabase = FirebaseDatabase.getInstance("https://joint-budget-f59f7.firebaseio.com/");
        databaseReference = firebaseDatabase.getReference();
    }

    @Override
    public String addItem(String eventID, ShoppingListItem item) {
        item.setEventID(eventID);
        DatabaseReference referenceToShoplist = databaseReference.child("shopList");
        String key = referenceToShoplist.push().getKey();
        item.setItemID(key);
        referenceToShoplist = referenceToShoplist.child(key);
        referenceToShoplist.setValue(item);
        return key;
    }

    @Override
    public void deleteItem(String EventID, String ShoplstItemID) {
        databaseReference.child("shopList/" + ShoplstItemID).removeValue();
    }

    @Override
    public void editItem(String eventID, ShoppingListItem item) {
        item.setEventID(eventID);
        databaseReference.child("shopList/" + item.getItemID()).setValue(item);

    }

    @Override
    public void getAllShops(final ShoppingListCallBack callback, String eventID) {
        DatabaseReference referenceToEvents = databaseReference.child("shopList");
        Query allShops = referenceToEvents.orderByChild("eventID").equalTo(eventID);
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<ShoppingListItem> items = new ArrayList<>();
                for (DataSnapshot itemSnapshot : dataSnapshot.getChildren()) {
                    items.add(itemSnapshot.getValue(ShoppingListItem.class));
                }
                callback.onLoad(items);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                throw new RuntimeException();
            }
        };

        allShops.addValueEventListener(eventListener);
    }


}
