package com.hogentessentials1.essentials.ui.login.ui.login

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.clearText
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.hogentessentials1.essentials.R
import org.hamcrest.core.IsNot.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Jonathan Vanden Eynden Van Lysebeth
 */

@RunWith(AndroidJUnit4ClassRunner::class)
class AuthenticationTest {
    @get: Rule
    val activityRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun test_changeManager_displaysMychangesAndDashboard() {
        onView(withId(R.id.username)).perform(typeText("Sukrit.bhattacharya@hogent.com"))
        onView(withId(R.id.password)).perform(typeText("P@ssword1"))
        onView(withId(R.id.login)).perform(click())
        Thread.sleep(2000)
        onView(withId(R.id.my_changes)).check(matches(isDisplayed()))
        onView(withId(R.id.dashboard)).check(matches(isDisplayed()))
    }

    @Test
    fun test_employeeCredentials_doesNotDisplayMychangesAndDashboard() {
        onView(withId(R.id.username)).perform(typeText("ziggy@hogent.com"))
        onView(withId(R.id.password)).perform(typeText("P@ssword1"))
        onView(withId(R.id.login)).perform(click())
        Thread.sleep(2000)
        onView(withId(R.id.my_changes)).check(matches((not(isDisplayed()))))
        onView(withId(R.id.dashboard)).check(matches((not(isDisplayed()))))
    }

    @Test
    fun test_wrongCredentials_Fails() {
        onView(withId(R.id.username)).perform(clearText()) // TODO weghalen nadat username niet meer automatisch is ingevuld
        onView(withId(R.id.username)).perform(typeText("fout@hogent.com"))
        onView(withId(R.id.password)).perform(typeText("test123"))
        onView(withId(R.id.login)).perform(click())
        Thread.sleep(2000)
        onView(withId(R.id.login)).check(matches((isDisplayed())))
    }
}
