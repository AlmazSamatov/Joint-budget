package joint_budget.joint_budget.Event.Purchases;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import joint_budget.joint_budget.DataTypes.Purchase;
import joint_budget.joint_budget.R;

public class PurchasesAdapter extends ArrayAdapter<Purchase> {

    private PurchasesView purchasesView;
    private List<Purchase> purchases;
    @BindView(R.id.title_event_item)
    TextView title;
    @BindView(R.id.second_field)
    TextView creatorName;
    @BindView(R.id.participants_number)
    TextView participantsAmount;
    @BindView(R.id.delete_event)
    ImageButton deleteEvent;
    @BindView(R.id.edit_event)
    ImageButton editEvent;

    public PurchasesAdapter(@NonNull Context context, int resource, @NonNull List<Purchase> objects, PurchasesView view) {
        super(context, resource, objects);
        purchases = objects;
        this.purchasesView = view;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull final ViewGroup parent) {
        final Purchase purchase = purchases.get(position);
        View view = null;

        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(
                    R.layout.event_item, parent, false);
        } else {
            view = convertView;
        }

        ButterKnife.bind(this, view);

        title.setText(purchase.getPurchaseName());
        String firstName = purchase.getPurchaseItems().get(0).getParticipantsOfPurchase().get(0).getFirstName();
        String lastName = purchase.getPurchaseItems().get(0).getParticipantsOfPurchase().get(0).getLastName();
        String name = firstName + ' ' + lastName;
        creatorName.setText(name);
        participantsAmount.setText(String.valueOf(purchase.getPurchaseItems().get(0).getParticipantsOfPurchase().size()));

        final String userID = purchase.getPurchaseItems().get(0).getParticipantsOfPurchase().get(0).getUserID();
        deleteEvent.setFocusable(false);
        deleteEvent.setFocusableInTouchMode(false);
        deleteEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                purchasesView.delete(userID, purchase);
            }
        });

        editEvent.setFocusable(false);
        editEvent.setFocusableInTouchMode(false);
        editEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                purchasesView.editPurchase(userID, purchase);
            }
        });

        return view;
    }
}
