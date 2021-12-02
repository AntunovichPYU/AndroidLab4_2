package com.example.myapplication

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationTest {
    @Before
    fun launch() {
        launchActivity<MainActivity>()
    }

    @Test
    fun testAbout() {
        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.bnToSecond)).perform(click())
        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.bnToThird)).perform(click())
        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        pressBack()
    }

    @Test
    fun testFragmentsNavigation() {
        //first fragment
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())

        //from first to second fragment
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToFirst)).perform(click())

        //from second to first fragment
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())

        //from second to third fragment
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())

        //from third to second fragment
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.bnToFirst)).perform(click())

        //from third to first fragment
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
    }

    @Test
    fun testNavigateUp() {
        //navigate up in first fragment
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).check(doesNotExist())
        onView(withId(R.id.bnToSecond)).perform(click())

        //navigate up in second fragment
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click())
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())

        //navigate up in third fragment
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click())
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
    }

    @Test
    fun testAboutNavigateUp() {
        //about from first fragment
        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click())
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())

        //about from second fragment
        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click())
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToThird)).perform(click())

        //about from third fragment
        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click())
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
    }
}