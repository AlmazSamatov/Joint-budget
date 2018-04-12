package joint_budget.joint_budget.Events.CreateEvent;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import joint_budget.joint_budget.DataTypes.Currency;
import joint_budget.joint_budget.DataTypes.Event;
import joint_budget.joint_budget.DataTypes.User;
import joint_budget.joint_budget.Events.Events.Model;

public class CreateEventPresenter implements CreateEventPresenterInterface {

    private CreateEventView view;
    private Model model;

    public CreateEventPresenter(CreateEventView view, Context context) throws IOException {
        this.view = view;
        model = new Model(context);
    }

    @Override
    public void setCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        view.setDates(dateFormat.format(date));
    }

    @Override
    public void saveEvent(String name, String startDate, String finalDate, ArrayList<User> users,
                          String currency) throws ParseException, IOException {
        Event event = new Event();
        event.setName(name);
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        event.setStartDate(format.parse(startDate));
        event.setEndDate(format.parse(finalDate));
        event.setParticipants(users);
        event.setCurrency(Currency.valueOf(currency));
        model.addEvent(event);
    }
}
