package joint_budget.joint_budget.Event.ShopList;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import joint_budget.joint_budget.DataTypes.ShoppingListItem;
import joint_budget.joint_budget.R;

public class ShopListAdapter extends ArrayAdapter<ShoppingListItem> {

    private ShopListView shopListView;
    private List<ShoppingListItem> items;
    @BindView(R.id.shoplist_item_name)
    TextView shoplistItemName;
    @BindView(R.id.edit_shoplist_item)
    Button editItem;
    @BindView(R.id.delete_shoplist_item)
    Button deleteItem;

    public ShopListAdapter(@NonNull Context context, int resource, @NonNull List<ShoppingListItem> objects, ShopListView view) {
        super(context, resource, objects);
        items = objects;
        shopListView = view;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull final ViewGroup parent) {
        final ShoppingListItem item = items.get(position);
        View view = null;

        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(
                    R.layout.shoplist_item, parent, false);
        } else {
            view = convertView;
        }

        ButterKnife.bind(this, view);

        shoplistItemName.setText(item.getName());

        deleteItem.setFocusable(false);
        deleteItem.setFocusableInTouchMode(false);
        deleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shopListView.delete(item);
            }
        });

        editItem.setFocusable(false);
        editItem.setFocusableInTouchMode(false);
        editItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shopListView.edit(item);
            }
        });

        return view;
    }
}

