package joint_budget.joint_budget;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import joint_budget.joint_budget.API.FIrebaseAPI.FirebaseEventsAPI;
import joint_budget.joint_budget.DataTypes.Event;

@RunWith(MockitoJUnitRunner.class)
public class EventTestAPI {
    @Mock
    private Event event;

    @Before
    public void setUp() {
        event = new Event();
        event.setName("Class");
    }

    @Test
    public void createEvent() {
        FirebaseEventsAPI api = new FirebaseEventsAPI();
        api.createEvent(event);


    }

}
