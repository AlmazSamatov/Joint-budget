package joint_budget.joint_budget.ui.module.events;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import joint_budget.joint_budget.Events.CreateEvent.CreateEventActivity;
import joint_budget.joint_budget.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class) @LargeTest
public class EventsActivityTest {

    @Rule
    public IntentsTestRule<CreateEventActivity> testRule = new IntentsTestRule<>(CreateEventActivity.class);

    @Test
    public void successCreateEventClickTest() throws InterruptedException {
        onView(withId(R.id.create_event)).perform(click());
        intended(hasComponent(testRule.getActivity().getComponentName()));
    }
}
