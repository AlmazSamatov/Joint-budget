package joint_budget.joint_budget.Event.Purchases;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import joint_budget.joint_budget.DataTypes.Purchase;
import joint_budget.joint_budget.Event.CreatePurchases.CreatePurchasesActivity;
import joint_budget.joint_budget.R;

public class FragmentPurchase extends Fragment implements PurchasesView {

    private PurchasesPresenterInterface presenter;
    private PurchasesAdapter purchasesAdapter;
    @BindView(R.id.purchases_listView)
    ListView purchasesListView;
    @BindView(R.id.add_purhcase)
    FloatingActionButton createPurchase;
    @BindView(R.id.empty_purchases)
    TextView emptyPurchases;
    @BindView(R.id.PurhcasesProgressBar)
    ProgressBar progressBar;
    private Context c;

    public FragmentPurchase(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.purchases_activity, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        initialize();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        c = context;
    }

    private void initialize() {
        presenter = new PurchasesPresenter(this);
        presenter.getData(this.getArguments());
        presenter.loadPurchases();
        createPurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchCreatePurchaseActivity(null);
            }
        });
    }

    @Override
    public void delete(String userID, Purchase purchase) {
        presenter.deletePurchase(userID, purchase);
        purchasesAdapter.notifyDataSetChanged();
    }

    @Override
    public void showPurchases(final List<Purchase> purchases) {
        purchasesAdapter = new PurchasesAdapter(c, R.layout.event_item, purchases,this);
        purchasesListView.setEmptyView(emptyPurchases);
        purchasesListView.setAdapter(purchasesAdapter);
    }

    @Override
    public void editPurchase(String userID, Purchase purchase) {
        presenter.editEvent(userID, purchase);
    }

    @Override
    public void turnOnProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void turnOffPrgoressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(c, error, Toast.LENGTH_SHORT).show();
    }

    public void launchCreatePurchaseActivity(Purchase previousPurchase){
        Intent intent = new Intent(c, CreatePurchasesActivity.class);
        if(previousPurchase != null){
            Gson gson = new Gson();
            String purchaseInJson = gson.toJson(previousPurchase);
            intent.putExtra("PreviousPurchase", purchaseInJson);
        }
        intent.putExtra("event", this.getArguments().getString("event"));
        intent.putExtra("eventID", presenter.getEventID());
        intent.putExtra("userID", presenter.getUserID());
        startActivity(intent);
    }
}
