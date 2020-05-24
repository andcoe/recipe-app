package org.andcoe.robots

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.andcoe.espresso.CustomViewAssertions
import org.andcoe.recipeapp.R

class CategoryListRobot {

    fun checkTitleIsDisplayed() {
        CustomViewAssertions.checkTitleIsDisplayed(R.string.category_list_title)
    }

    fun checkListIsDisplayed() {
        onView(withId(R.id.categoryList)).check(matches(isDisplayed()))
    }

}