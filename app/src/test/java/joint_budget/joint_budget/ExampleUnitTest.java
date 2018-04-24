package joint_budget.joint_budget;

import org.junit.Test;

import java.util.List;

import joint_budget.joint_budget.API.EventsAPI;
import joint_budget.joint_budget.API.FIrebaseAPI.FirebaseEventsAPI;
import joint_budget.joint_budget.DataTypes.Event;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        FirebaseEventsAPI api = new FirebaseEventsAPI();
        EventsAPI.LoadEventsCallback callback = new EventsAPI.LoadEventsCallback() {
            @Override
            public void onLoad(List<Event> events) {
                System.out.println(events);
            }
        };
        Event event = new Event();
        event.setName("test");
        api.createEvent(event);
    }
}