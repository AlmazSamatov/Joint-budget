package joint_budget.joint_budget.Events.CreateEvent;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

import java.util.Calendar;
import joint_budget.joint_budget.R;

@SuppressLint("ValidFragment")
public class DatePicker extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    CreateEventView view;
    boolean isStartDate;

    @SuppressLint("ValidFragment")
    DatePicker(CreateEventActivity activity, boolean isStartDate){
        view = activity;
        this.isStartDate = isStartDate;
        setStyle(R.style.MyDatePickerStyle, getTheme());
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // set current date
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // create DatePickerDialog and return it
        Dialog picker = new DatePickerDialog(getActivity(), this, year, month, day);
        picker.setTitle(getResources().getString(R.string.choose_date));

        return picker;
    }

    @Override
    public void onDateSet(android.widget.DatePicker datePicker, int year, int month, int day) {

        String dayText = String.valueOf(day);
        String yearText = String.valueOf(year);
        String monthText = String.valueOf(month);
        String date = dayText + '/' + monthText + '/' + yearText;
        if(isStartDate)
            view.setStartDate(date);
        else
            view.setFinalDate(date);
    }
}
