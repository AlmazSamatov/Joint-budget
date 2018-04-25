package joint_budget.joint_budget.Event.Purchases;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import io.realm.Realm;
import joint_budget.joint_budget.DataTypes.Purchase;
import joint_budget.joint_budget.Event.CreatePurchases.CreatePurchasesActivity;
import joint_budget.joint_budget.R;

public class PurchasesActivity extends AppCompatActivity implements PurchasesView {

    private PurchasesPresenterInterface presenter;
    private PurchasesAdapter purchasesAdapter;
    @BindView(R.id.purchases_listView)
    ListView purchasesListView;
    @BindView(R.id.add_purhcase)
    FloatingActionButton createPurchase;
    @BindView(R.id.empty_purchases)
    TextView emptyPurchases;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.purchases_activity);
        initialize();
    }

    private void initialize() {
        presenter = new PurchasesPresenter(this);
        presenter.loadPurchases();
    }

    @Override
    public void delete(Purchase purchase) {
        presenter.deletePurchase(purchase);
        purchasesAdapter.notifyDataSetChanged();
    }

    @Override
    public void showPurchases(final List<Purchase> purchases) {
        purchasesAdapter = new PurchasesAdapter(this, R.layout.event_item, purchases,this);
        purchasesListView.setEmptyView(emptyPurchases);
        purchasesListView.setAdapter(purchasesAdapter);
        purchasesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                launchCreatePurchaseActivity(purchases.get(i));
            }
        });
    }

    public void onPurchaseCreate(){
        launchCreatePurchaseActivity(null);
    }

    @Override
    public void editPurchase(Purchase purchase) {
        launchCreatePurchaseActivity(purchase);
    }

    public void launchCreatePurchaseActivity(Purchase previousPurchase){
        Intent intent = new Intent(getBaseContext(), CreatePurchasesActivity.class);
        if(previousPurchase != null){
            Gson gson = new Gson();
            String purchaseInJson = gson.toJson(Realm.getDefaultInstance().copyFromRealm(previousPurchase));
            intent.putExtra("PreviousPurchase", purchaseInJson);
        }
        startActivity(intent);
    }
}
