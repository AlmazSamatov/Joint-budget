package joint_budget.joint_budget.Event.ShopList;

import android.content.Intent;

import com.google.gson.Gson;

import joint_budget.joint_budget.DataTypes.Event;
import joint_budget.joint_budget.DataTypes.ShoppingListItem;

public class ShopListPresenter implements ShopListPresenterInterface {

    ShopListView view;
    Event event;

    ShopListPresenter(ShopListView view){
        this.view = view;
    }

    @Override
    public void addShoplistItem(ShoppingListItem purchase) {

    }

    @Override
    public void editShoplistItem(ShoppingListItem purchase) {

    }

    @Override
    public void deleteShoplistItem(ShoppingListItem purchase) {

    }

    @Override
    public void setEvent(Intent intent) {
        String eventInJson = intent.getStringExtra("Event");
        if(eventInJson != null){
            Gson gson = new Gson();
            event = gson.fromJson(eventInJson, Event.class);
        }
    }
}
