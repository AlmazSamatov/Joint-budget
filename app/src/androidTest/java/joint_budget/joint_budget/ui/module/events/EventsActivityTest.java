package joint_budget.joint_budget.ui.module.events;

import android.content.ComponentName;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import joint_budget.joint_budget.Events.CreateEvent.CreateEventActivity;
import joint_budget.joint_budget.R;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class) @LargeTest
public class EventsActivityTest {

    @Test
    public void successCreateEventClickTest() {
        onView(withId(R.id.create_event)).perform(click());
        intended(hasComponent(new ComponentName(getTargetContext(), CreateEventActivity.class)));
    }
}
