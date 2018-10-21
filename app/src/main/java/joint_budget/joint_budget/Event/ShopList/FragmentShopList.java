package joint_budget.joint_budget.Event.ShopList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import joint_budget.joint_budget.DataTypes.ShoppingListItem;
import joint_budget.joint_budget.R;

public class FragmentShopList extends Fragment implements ShopListView {

    ShopListPresenterInterface presenter;
    ShopListAdapter adapter;
    @BindView(R.id.shoplist_listView)
    ListView shopListView;
    @BindView(R.id.empty_shoplist)
    TextView empty;
    @BindView(R.id.add_item)
    FloatingActionButton addItem;
    @BindView(R.id.ShoplistProgressBar)
    ProgressBar shoplistProgressBar;
    @BindView(R.id.swipeShoplist)
    FrameLayout swipeShopList;
    private Context c;

    public FragmentShopList(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shoplist_activity, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        c = context;
    }

    @Override
    public void onStart() {
        super.onStart();
        initialize();
    }

    private void initialize() {
        presenter = new ShopListPresenter(this);
        presenter.getCurrentUser(this.getArguments());
        presenter.setEvent(this.getArguments());
        presenter.loadItems();
        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.addShoplistItem();
            }
        });
    }

    @Override
    public void showItems(final List<ShoppingListItem> items){
        adapter = new ShopListAdapter(c, R.layout.shoplist_item, items, this);
        shopListView.setEmptyView(empty);
        shopListView.setAdapter(adapter);
    }

    public void launchShopListItemChange(ShoppingListItem shoppingListItem) {
        Intent intent = new Intent(c, ShopListItemActivity.class);
        if(shoppingListItem != null){
            Gson gson = new Gson();
            String itemInJson = gson.toJson(shoppingListItem);
            intent.putExtra("Item", itemInJson);
        }
        intent.putExtra("eventID", this.getArguments().getString("eventID"));
        intent.putExtra("userID", this.getArguments().getString("userID"));
        startActivity(intent);
    }

    @Override
    public void turnOnProgressBar() {
        swipeShopList.setVisibility(View.GONE);
        shoplistProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void turnOffProgressBar() {
        swipeShopList.setVisibility(View.VISIBLE);
        shoplistProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void delete(ShoppingListItem item) {
        presenter.deleteShoplistItem(item);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void edit(ShoppingListItem item) {
        presenter.editShoplistItem(item);
    }


}
