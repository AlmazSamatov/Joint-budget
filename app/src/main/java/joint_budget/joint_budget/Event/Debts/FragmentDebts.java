package joint_budget.joint_budget.Event.Debts;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import joint_budget.joint_budget.DataTypes.Debt;
import joint_budget.joint_budget.R;

public class FragmentDebts extends Fragment implements DebtsView {

    DebtsPresenterInterface presenter;
    DebtsAdapter adapter;
    @BindView(R.id.debts_listView)
    ListView debtsListView;
    @BindView(R.id.empty_debts)
    TextView empty;
    @BindView(R.id.swipeDebts)
    FrameLayout swipeDebts;
    @BindView(R.id.DebtsProgressBar)
    ProgressBar progressBar;
    private Context c;

    public FragmentDebts(){};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.debts_activity, container, false);
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
        presenter = new DebtsPresenter(this);
        presenter.getCurrentUser(this.getArguments());
        presenter.loadDebts();
    }

    @Override
    public void showDebts(final List<Debt> debts) {
        adapter = new DebtsAdapter(c, R.layout.debt_item, debts);
        debtsListView.setAdapter(adapter);
        debtsListView.setEmptyView(empty);
        debtsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(debts.get(i).getCreditor() != null &&
                        debts.get(i).getCreditor().getUserID().equals(presenter.getUserID())){
                    areYouSure(debts.get(i));
                } else{
                    Toast.makeText(c, "You can not mark it as returned", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void areYouSure(final Debt debt){
        new AlertDialog.Builder(c)
                .setTitle("Confirm")
                .setMessage("Do you really want to delete this purchase?")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        presenter.deleteDebt(debt);
                    }})
                .setNegativeButton(android.R.string.no, null).show();
    }

    @Override
    public void updateListView() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void turnOnProgressBar() {
        swipeDebts.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void turnOffProgressBar() {
        swipeDebts.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }
}
