package org.andcoe.robots

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.andcoe.espresso.CustomViewAssertions
import org.andcoe.recipeapp.R

class CategoryRecipesRobot {

    fun checkTitleIsDisplayed() {
        CustomViewAssertions.checkTitleIsDisplayed(R.string.category_recipes_title)
    }

    fun checkCategoryNameIsDisplayed(categoryName: String) {
        onView(withId(R.id.categoryName))
            .check(matches(withText(categoryName)))
            .check(matches(isDisplayed()))
    }
}
