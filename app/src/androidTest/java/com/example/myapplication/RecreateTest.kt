package com.example.myapplication

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RecreateTest {
    @Test
    fun testRecreate() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        activityScenario.onActivity { activity ->
            activity.recreate()
        }
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(ViewActions.click())

        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        activityScenario.onActivity { activity ->
            activity.recreate()
        }
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToThird)).perform(ViewActions.click())

        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        activityScenario.onActivity { activity ->
            activity.recreate()
        }
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))

        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        activityScenario.onActivity { activity ->
            activity.recreate()
        }
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
    }
}