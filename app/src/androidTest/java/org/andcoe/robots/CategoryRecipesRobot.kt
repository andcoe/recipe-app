package org.andcoe.robots

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import org.andcoe.espresso.CustomMatchers.recyclerHasAtPosition
import org.andcoe.espresso.CustomViewAssertions
import org.andcoe.recipeapp.R
import org.andcoe.recipeapp.categoryrecipes.model.CategoryRecipeItem

class CategoryRecipesRobot : BaseRobot() {

    fun clickItemAtPosition(index: Int) {
        onView(withId(R.id.categoryRecipesList))
            .perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(index, click()))
    }

    fun checkTitleIsDisplayed(categoryName: String) {
        CustomViewAssertions.checkTitleIsDisplayed(R.string.category_recipes_title, categoryName)
    }

    fun checkListIsDisplayed() {
        onView(withId(R.id.categoryRecipesList)).check(matches(isDisplayed()))
    }

    fun checkListIsNotDisplayed() {
        onView(withId(R.id.categoryRecipesList)).check(doesNotExist())
    }

    fun checkListContains(categoryRecipeItem: CategoryRecipeItem) {
        onView(withId(R.id.categoryRecipesList))
            .check(
                matches(
                    recyclerHasAtPosition(
                        0,
                        hasDescendant(withText(categoryRecipeItem.name))
                    )
                )
            )
    }

}
