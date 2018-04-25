package joint_budget.joint_budget.Event.ShopList;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import joint_budget.joint_budget.DataTypes.ShoppingListItem;
import joint_budget.joint_budget.R;

public class ShopListActivity extends AppCompatActivity implements ShopListView {

    ShopListPresenterInterface presenter;
    ShopListAdapter adapter;
    @BindView(R.id.shoplist_listView)
    ListView shopListView;
    @BindView(R.id.empty_shoplist)
    TextView empty;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shoplist_activity);
        initialize();
    }

    private void initialize() {
        presenter = new ShopListPresenter(this);
        presenter.getCurrentUser(getIntent());
        presenter.setEvent(getIntent());
    }

    @Override
    public void showItems(final List<ShoppingListItem> items){
        adapter = new ShopListAdapter(this, R.layout.shoplist_item, items, this);
        shopListView.setEmptyView(empty);
        shopListView.setAdapter(adapter);
        shopListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                launchShopListItemChange(items.get(i));
            }
        });
    }

    public void launchShopListItemChange(ShoppingListItem shoppingListItem) {
        Intent intent = new Intent(getBaseContext(), ShopListItemActivity.class);
        Gson gson = new Gson();
        String itemInJson = gson.toJson(shoppingListItem);
        intent.putExtra("Item", itemInJson);
        startActivity(intent);
    }

    @Override
    public void delete(ShoppingListItem item) {
        presenter.deleteShoplistItem(item);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void edit(ShoppingListItem item) {
        presenter.editShoplistItem(item);
        adapter.notifyDataSetChanged();
    }
}
