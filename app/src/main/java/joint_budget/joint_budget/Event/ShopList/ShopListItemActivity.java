package joint_budget.joint_budget.Event.ShopList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import joint_budget.joint_budget.DataTypes.ShoppingListItem;
import joint_budget.joint_budget.Model.ShoplistModel;
import joint_budget.joint_budget.R;

public class ShopListItemActivity extends AppCompatActivity {

    @BindView(R.id.shoplist_item_name)
    TextInputEditText itemName;
    private ShoppingListItem previousItem;
    private String eventID;
    private ShoplistModel shoplistModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_shoplist_item);
        initialize();
    }

    private void initialize() {
        ButterKnife.bind(this);
        getData();
        shoplistModel = ShoplistModel.getInstance();
    }

    public void saveOnClick(View view) {
        savePurchaseItem();
        finish();
    }

    public void cancelOnClick(View view) {
        finish();
    }

    public void savePurchaseItem(){
        if(previousItem == null){
            ShoppingListItem item = new ShoppingListItem(itemName.getText().toString());
            shoplistModel.addItem(eventID, item);
        } else{
            previousItem.setName(itemName.getText().toString());
            shoplistModel.editItem(eventID, previousItem);
        }
    }

    public void getData() {
        String previousItemInJson = getIntent().getStringExtra("Item");
        if(previousItemInJson != null){
            Gson gson = new Gson();
            previousItem = gson.fromJson(previousItemInJson, ShoppingListItem.class);
            itemName.setText(previousItem.getName());
        }
        eventID = getIntent().getStringExtra("eventID");
    }
}
