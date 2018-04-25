package joint_budget.joint_budget.Event;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TabHost;

import butterknife.BindView;
import butterknife.ButterKnife;
import joint_budget.joint_budget.Event.Debts.DebtsActivity;
import joint_budget.joint_budget.Event.Purchases.PurchasesActivity;
import joint_budget.joint_budget.Event.ShopList.ShopListActivity;
import joint_budget.joint_budget.R;

public class EventActivity extends TabActivity {

    private String userID;
    @BindView(android.R.id.tabhost)
    TabHost tabHost;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_activity);
        initialize();
    }

    private void initialize() {
        ButterKnife.bind(this);
        getUserID();
        initializeTab();
    }

    private void initializeTab() {
        tabHost.setup();
        TabHost.TabSpec tabSpec;

        tabSpec = tabHost.newTabSpec("tag1");
        tabSpec.setIndicator("Purchases");
        Intent purhasesIntent = new Intent(this, PurchasesActivity.class);
        purhasesIntent.putExtra("Event", getIntent().getStringExtra("Event"));
        purhasesIntent.putExtra("userID", userID);
        tabSpec.setContent(purhasesIntent);
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag2");
        tabSpec.setIndicator("Debts");
        Intent debtsIntent = new Intent(this, DebtsActivity.class);
        debtsIntent.putExtra("Event", getIntent().getStringExtra("Event"));
        debtsIntent.putExtra("userID", userID);
        tabSpec.setContent(debtsIntent);
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag3");
        tabSpec.setIndicator("Shoplist");
        Intent shopListIntent = new Intent(this, ShopListActivity.class);
        shopListIntent.putExtra("Event", getIntent().getStringExtra("Event"));
        shopListIntent.putExtra("userID", userID);
        tabSpec.setContent(shopListIntent);
        tabHost.addTab(tabSpec);
    }

    public void getUserID() {
        userID = getIntent().getStringExtra("userID");
    }
}