package joint_budget.joint_budget.Event;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import joint_budget.joint_budget.DataTypes.Event;
import joint_budget.joint_budget.Event.Debts.FragmentDebts;
import joint_budget.joint_budget.Event.Purchases.FragmentPurchase;
import joint_budget.joint_budget.Event.ShopList.FragmentShopList;
import joint_budget.joint_budget.R;

public class EventActivity extends AppCompatActivity {

    private String userID;
    @BindView(R.id.tabs)
    TabLayout tabLayout;

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

        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        Bundle bundle = new Bundle();
        bundle.putString("event", getIntent().getStringExtra("Event"));
        bundle.putString("eventID", getEventID());
        bundle.putString("userID", userID);

        FragmentPurchase fragmentPurchase = new FragmentPurchase();
        fragmentPurchase.setArguments(bundle);

        FragmentDebts fragmentDebts = new FragmentDebts();
        fragmentDebts.setArguments(bundle);

        FragmentShopList fragmentShopList = new FragmentShopList();
        fragmentShopList.setArguments(bundle);

        // Add Fragments to adapter one by one
        adapter.addFragment(fragmentPurchase, "Purchases");
        adapter.addFragment(fragmentDebts, "Debts");
        adapter.addFragment(fragmentShopList, "Shoplist");
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
    }

    public void getUserID() {
        userID = getIntent().getStringExtra("userID");
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    public String getEventID(){
        String eventInJson = getIntent().getStringExtra("Event");
        Gson gson = new Gson();
        Event event = gson.fromJson(eventInJson, Event.class);
        return event.getEventId();
    }
}