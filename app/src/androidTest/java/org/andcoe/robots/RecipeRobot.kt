package org.andcoe.robots

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.andcoe.espresso.CustomViewAssertions
import org.andcoe.recipeapp.R

class RecipeRobot : BaseRobot() {

    fun checkTitleIsDisplayed(recipeName: String) {
        CustomViewAssertions.checkTitleIsDisplayed(R.string.recipe_title, recipeName)
    }

    fun checkImageIsDisplayed() {
        onView(withId(R.id.recipeImage)).check(matches(isDisplayed()))
    }

    fun checkInstructions(instructions: String) {
        onView(withId(R.id.recipeInstructions))
            .check(matches(withText(instructions)))
            .check(matches(isDisplayed()))
    }

}
