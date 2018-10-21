package joint_budget.joint_budget.Event.Debts;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import joint_budget.joint_budget.DataTypes.Debt;
import joint_budget.joint_budget.R;

public class DebtsAdapter extends ArrayAdapter<Debt> {

    private List<Debt> debts;
    @BindView(R.id.from)
    TextView from;
    @BindView(R.id.to)
    TextView to;
    @BindView(R.id.debt_cost_value)
    TextView cost;


    public DebtsAdapter(@NonNull Context context, int resource, @NonNull List<Debt> objects) {
        super(context, resource, objects);
        debts = objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull final ViewGroup parent) {
        final Debt debt = debts.get(position);
        View view = null;

        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(
                    R.layout.debt_item, parent, false);
        } else {
            view = convertView;
        }

        ButterKnife.bind(this, view);

        String debtorName = debt.getDebtor().getUserName();
        if(debt.getDebtor().getUserID() != null)
            debtorName = debt.getDebtor().getFirstName() + ' ' + debt.getDebtor().getLastName();

        String creditorName = debt.getCreditor().getUserName();
        if(debt.getCreditor().getUserID() != null)
            creditorName = debt.getCreditor().getFirstName() + ' ' + debt.getCreditor().getLastName();

        from.setText(debtorName);
        to.setText(creditorName);
        cost.setText(Double.toString(debt.getAmountOfDebt()));


        return view;
    }

}
