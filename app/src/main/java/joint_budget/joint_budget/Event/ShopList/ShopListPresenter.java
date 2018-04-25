package joint_budget.joint_budget.Event.ShopList;

import android.content.Intent;

import com.google.gson.Gson;

import joint_budget.joint_budget.DataTypes.Event;
import joint_budget.joint_budget.DataTypes.ShoppingListItem;

public class ShopListPresenter implements ShopListPresenterInterface {

    ShopListView view;
    Event event;
    private String userID;

    ShopListPresenter(ShopListView view){
        this.view = view;
    }

    @Override
    public void addShoplistItem(ShoppingListItem item) {

    }

    @Override
    public void editShoplistItem(ShoppingListItem item) {

    }

    @Override
    public void deleteShoplistItem(ShoppingListItem item) {

    }

    @Override
    public void loadItems(){

        //view.showItems();
    }

    @Override
    public void setEvent(Intent intent) {
        String eventInJson = intent.getStringExtra("Event");
        if(eventInJson != null){
            Gson gson = new Gson();
            event = gson.fromJson(eventInJson, Event.class);
        }
    }

    @Override
    public void getCurrentUser(Intent intent) {
        userID = intent.getStringExtra("userID");
    }

    @Override
    public String getUserID() {
        return userID;
    }
}
