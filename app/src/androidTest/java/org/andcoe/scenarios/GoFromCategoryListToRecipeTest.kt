package org.andcoe.scenarios

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.andcoe.recipeapp.categories.view.CategoryListActivity
import org.andcoe.robots.CategoryListRobot
import org.andcoe.robots.CategoryRecipesRobot
import org.andcoe.robots.RecipeRobot
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class GoFromCategoryListToRecipeTest {

    @get:Rule
    var activityRule = ActivityTestRule(CategoryListActivity::class.java)

    private val categoryListRobot = CategoryListRobot()
    private val categoryRecipesRobot = CategoryRecipesRobot()
    private val recipeRobot = RecipeRobot()

    @Test
    fun openCategoryListSelectsCategoryAndGoesToRecipeDetail() {
        categoryListRobot.checkListIsDisplayed()
        categoryListRobot.clickItemAtPosition(0)
        categoryListRobot.checkListIsNotDisplayed()

        categoryRecipesRobot.checkListIsDisplayed()
        categoryRecipesRobot.clickItemAtPosition(0)
        categoryRecipesRobot.checkListIsNotDisplayed()

        recipeRobot.checkTitleIsDisplayed("Tomato and pesto spaghetti")
    }

}