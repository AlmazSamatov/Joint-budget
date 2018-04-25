package joint_budget.joint_budget.Event.Debts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import joint_budget.joint_budget.DataTypes.Debt;
import joint_budget.joint_budget.R;

public class DebtsActivity extends AppCompatActivity implements DebtsView {

    DebtsPresenterInterface presenter;
    DebtsAdapter adapter;
    @BindView(R.id.debts_listView)
    ListView debtsListView;
    @BindView(R.id.empty_debts)
    TextView empty;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.debts_activity);
        initialize();
    }

    private void initialize() {
        presenter = new DebtsPresenter(this);
        presenter.loadDebts();
    }

    @Override
    public void showDebts(final List<Debt> debts) {
        adapter = new DebtsAdapter(this, R.layout.debt_item, debts);
        debtsListView.setAdapter(adapter);
        debtsListView.setEmptyView(empty);
        debtsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                presenter.deleteDebt(debts.get(i));
            }
        });
    }

    @Override
    public void updateListView() {
        adapter.notifyDataSetChanged();
    }
}
