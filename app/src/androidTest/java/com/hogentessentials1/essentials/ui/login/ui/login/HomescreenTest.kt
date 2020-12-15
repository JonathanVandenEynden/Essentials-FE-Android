package com.hogentessentials1.essentials.ui.login.ui.login


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.hogentessentials1.essentials.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class HomescreenTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(LoginActivity::class.java)

    @Test
    fun homescreenTest() {
        val appCompatEditText = onView(
            allOf(
                withId(R.id.password),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.ScrollView")),
                        0
                    ),
                    1
                )
            )
        )
        appCompatEditText.perform(scrollTo(), replaceText("P@ssword1"), closeSoftKeyboard())

        val materialButton = onView(
            allOf(
                withId(R.id.login), withText("Sign in"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.ScrollView")),
                        0
                    ),
                    4
                )
            )
        )
        materialButton.perform(scrollTo(), click())
        Thread.sleep(2000)
        val textView = onView(
            allOf(
                withText("Essentials"),
                withParent(
                    allOf(
                        withId(R.id.action_bar),
                        withParent(withId(R.id.action_bar_container))
                    )
                ),
                isDisplayed()
            )
        )
        textView.check(matches(withText("Essentials")))

        val button = onView(
            allOf(
                withId(R.id.changes), withText(R.string.changes),
                withParent(withParent(withId(R.id.scrollView3))),
                isDisplayed()
            )
        )
        button.check(matches(isDisplayed()))

        val button2 = onView(
            allOf(
                withId(R.id.surveys), withText(R.string.surveys),
                withParent(withParent(withId(R.id.scrollView3))),
                isDisplayed()
            )
        )
        button2.check(matches(isDisplayed()))

        val button3 = onView(
            allOf(
                withId(R.id.my_team), withText(R.string.my_teams),
                withParent(withParent(withId(R.id.scrollView3))),
                isDisplayed()
            )
        )
        button3.check(matches(isDisplayed()))
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
