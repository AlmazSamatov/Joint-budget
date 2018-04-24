package joint_budget.joint_budget.Event.ShopList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import joint_budget.joint_budget.DataTypes.ShoppingListItem;

public class ShopListActivity extends AppCompatActivity implements ShopListView {

    ShopListPresenterInterface presenter;
    ShopListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
    }

    private void initialize() {
        presenter = new ShopListPresenter(this);
    }

    @Override
    public void delete(ShoppingListItem item) {
        presenter.deleteShoplistItem();
    }

    @Override
    public void edit(ShoppingListItem item) {

    }
}
