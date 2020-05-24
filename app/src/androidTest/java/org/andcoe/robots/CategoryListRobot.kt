package org.andcoe.robots

import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.andcoe.recipeapp.R
import org.andcoe.recipeapp.core.App
import org.hamcrest.CoreMatchers.allOf

class CategoryListRobot {

    fun checkTitleIsDisplayed() {
        val resources = ApplicationProvider.getApplicationContext<App>().resources
        onView(
            allOf(
                withText(resources.getString(R.string.category_list_title)),
                isDescendantOfA(withResourceName("action_bar"))
            )
        ).check(matches(isDisplayed()))
    }

    fun checkListIsDisplayed() {
        onView(withId(R.id.categoryList)).check(matches(isDisplayed()))
    }

}