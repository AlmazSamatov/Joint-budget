package joint_budget.joint_budget.Events.CreateEvent;

public interface CreateEventView {

    void setDates(String format);
    void setStartDate(String date);
    void setFinalDate(String date);
    void startEventsActivity();
    void showError(String errorMessage);
}
