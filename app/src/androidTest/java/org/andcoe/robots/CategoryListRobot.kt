package org.andcoe.robots

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.andcoe.espresso.CustomViewAssertions
import org.andcoe.recipeapp.R

class CategoryListRobot {

    fun clickItemAtPosition(index: Int) {
        onView(withId(R.id.categoryList))
            .perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(index, click()))
    }

    fun checkTitleIsDisplayed() {
        CustomViewAssertions.checkTitleIsDisplayed(R.string.category_list_title)
    }

    fun checkListIsDisplayed() {
        onView(withId(R.id.categoryList)).check(matches(isDisplayed()))
    }

    fun checkListIsNotDisplayed() {
        onView(withId(R.id.categoryList)).check(doesNotExist())
    }

}