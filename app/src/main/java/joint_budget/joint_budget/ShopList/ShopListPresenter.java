package joint_budget.joint_budget.ShopList;

import joint_budget.joint_budget.DataTypes.Event;
import joint_budget.joint_budget.DataTypes.ShoppingListItem;

public class ShopListPresenter implements ShopListPresenterInterface {

    ShopListView view;

    ShopListPresenter(){
        view = new ShopListActivity();
    }

    public void addPurchase(ShoppingListItem purchase, Event event) {

    }

    public void editPurchase(ShoppingListItem purchase, Event event) {

    }

    public void deletePurchase(ShoppingListItem purchase, Event event) {

    }
}
