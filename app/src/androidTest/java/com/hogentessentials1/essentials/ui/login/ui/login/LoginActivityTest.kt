package com.hogentessentials1.essentials.ui.login.ui.login

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.hogentessentials1.essentials.R
import org.hamcrest.core.IsNot.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Jonathan Vanden Eynden
 */

@RunWith(AndroidJUnit4ClassRunner::class)
class LoginActivityTest {

    @get: Rule
    val activityRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun test_isLoginActivityInView() {
        onView(withId(R.id.container)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isVisible_signInButton() {
        onView(withId(R.id.login)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isSignInTextCorrect() {
        onView(withId(R.id.login)).check(matches(withText(R.string.action_sign_in)))
    }

    @Test
    fun test_isUsernameTextFieldInView() {
        onView(withId(R.id.username)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isPasswordTextFieldInView() {
        onView(withId(R.id.password)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isSignInButtonDisabled_withoutInputInPasswordTextField() {
        onView(withId(R.id.login)).check(matches(not(isEnabled())))
    }

    @Test
    fun test_isSignInButtonEnabled_withInputInUsernameAndPasswordTextField() {
        onView(withId(R.id.username)).perform(typeText("username"))
        onView(withId(R.id.password)).perform(typeText("password123"))
        onView(withId(R.id.login)).check(matches(isEnabled()))
    }

    @Test
    fun test_navMainActivity() {
        onView(withId(R.id.username)).perform(typeText("Sukrit.bhattacharya@hogent.com"))
        onView(withId(R.id.password)).perform(typeText("P@ssword1"))
        onView(withId(R.id.login)).perform(click())
        Thread.sleep(2000)
        onView(withId(R.id.constrainedlayout)).check(matches(isDisplayed()))
    }
}
