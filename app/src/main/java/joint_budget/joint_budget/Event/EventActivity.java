package joint_budget.joint_budget.Event;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;

import butterknife.BindView;
import butterknife.ButterKnife;
import joint_budget.joint_budget.R;

public class EventActivity extends AppCompatActivity {

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
        initializeTab();
    }

    private void initializeTab() {
        tabHost.setup();
        TabHost.TabSpec tabSpec;

        tabSpec = tabHost.newTabSpec("tag1");
        tabSpec.setIndicator("Purchases");
        tabSpec.setContent(R.id.tab1);
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag2");
        tabSpec.setIndicator("Debts");
        tabSpec.setContent(R.id.tab2);
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag3");
        tabSpec.setIndicator("Shoplist");
        tabSpec.setContent(R.id.tab3);
        tabHost.addTab(tabSpec);
    }
}