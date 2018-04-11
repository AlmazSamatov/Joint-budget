package joint_budget.joint_budget.Events.CreateEvent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateEventPresenter implements CreateEventPresenterInterface {

    private CreateEventView view;

    public CreateEventPresenter(){
        view = new CreateEventActivity();
    }

    @Override
    public void setCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        view.setDates(dateFormat.format(date));
    }
}
