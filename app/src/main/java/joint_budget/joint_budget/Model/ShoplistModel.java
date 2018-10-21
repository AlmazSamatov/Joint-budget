package joint_budget.joint_budget.Model;

import java.util.ArrayList;
import java.util.List;

import joint_budget.joint_budget.API.FIrebaseAPI.FirebaseShoplistAPI;
import joint_budget.joint_budget.API.ShoplistAPI;
import joint_budget.joint_budget.DataTypes.ShoppingListItem;

public class ShoplistModel {

    private List<ShoppingListItem> items;
    private FirebaseShoplistAPI itemsAPI;
    private static volatile ShoplistModel instance;

    public static ShoplistModel getInstance() {
        ShoplistModel localInstance = instance;
        if (localInstance == null) {
            synchronized (ShoplistModel.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new ShoplistModel();
                }
            }
        }
        return localInstance;
    }

    private ShoplistModel(){
        items = new ArrayList<>();
        itemsAPI = new FirebaseShoplistAPI();
    }

    public void addItem(String eventID, ShoppingListItem item) {
        String id = itemsAPI.addItem(eventID, item);
        item.setItemID(id);
        items.add(item);
    }

    public void deleteItem(String eventID, String shoplistItemID) {
        itemsAPI.deleteItem(eventID, shoplistItemID);
        deleteItemFromLocal(shoplistItemID);
    }

    private void deleteItemFromLocal(String itemID) {
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).getItemID().equals(itemID)){
                items.remove(i);
                break;
            }
        }
    }

    public void editItem(String eventID, ShoppingListItem item) {
        itemsAPI.editItem(eventID, item);
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).getItemID().equals(item.getItemID())){
                items.set(i, item);
                break;
            }
        }
    }

    public void getAllShops(final ShoplistAPI.ShoppingListCallBack callback, String eventID) {
        itemsAPI.getAllShops(callback, eventID);
    }

    public void setShopList(List<ShoppingListItem> shopList) {
        this.items = shopList;
    }
}
