package joint_budget.joint_budget.Event.ShopList;

import android.os.Bundle;

import com.google.gson.Gson;

import java.util.List;

import joint_budget.joint_budget.API.ShoplistAPI;
import joint_budget.joint_budget.DataTypes.Event;
import joint_budget.joint_budget.DataTypes.ShoppingListItem;
import joint_budget.joint_budget.Model.ShoplistModel;

public class ShopListPresenter implements ShopListPresenterInterface {

    ShopListView view;
    Event event;
    private String userID;
    private ShoplistModel shoplistModel;

    ShopListPresenter(ShopListView view){
        this.view = view;
        shoplistModel = ShoplistModel.getInstance();
    }

    @Override
    public void addShoplistItem() {
        view.launchShopListItemChange(null);
    }

    @Override
    public void editShoplistItem(ShoppingListItem item) {
        view.launchShopListItemChange(item);
    }

    @Override
    public void deleteShoplistItem(ShoppingListItem item) {
        shoplistModel.deleteItem(event.getEventId(), item.getItemID());
    }

    @Override
    public void loadItems(){
        view.turnOnProgressBar();
        shoplistModel.getAllShops(new ShoplistAPI.ShoppingListCallBack() {
            @Override
            public void onLoad(List<ShoppingListItem> items) {
                view.turnOffProgressBar();
                shoplistModel.setShopList(items);
                view.showItems(items);
            }
        }, event.getEventId());
    }

    @Override
    public void setEvent(Bundle bundle) {
        if(bundle != null){
            String eventInJson = bundle.getString("event");
            if(eventInJson != null){
                Gson gson = new Gson();
                event = gson.fromJson(eventInJson, Event.class);
            }
        }
    }

    @Override
    public void getCurrentUser(Bundle bundle) {
        if(bundle != null)
            userID = bundle.getString("userID");
    }

    @Override
    public String getUserID() {
        return userID;
    }
}
