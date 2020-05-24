package org.andcoe.robots

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.andcoe.espresso.CustomMatchers.recyclerHasAtPosition
import org.andcoe.espresso.CustomViewAssertions
import org.andcoe.recipeapp.R
import org.andcoe.recipeapp.categoryrecipes.model.RecipeItem

class CategoryRecipesRobot {

    fun checkTitleIsDisplayed() {
        CustomViewAssertions.checkTitleIsDisplayed(R.string.category_recipes_title)
    }

    fun checkCategoryNameIsDisplayed(categoryName: String) {
        onView(withId(R.id.categoryName))
            .check(matches(withText(categoryName)))
            .check(matches(isDisplayed()))
    }

    fun checkListContains(recipeItem: RecipeItem) {
        onView(withId(R.id.categoryRecipesList))
            .check(matches(recyclerHasAtPosition(0, hasDescendant(withText(recipeItem.name)))))
    }

}
