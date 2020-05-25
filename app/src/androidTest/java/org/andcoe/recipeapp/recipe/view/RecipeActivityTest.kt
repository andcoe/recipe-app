package org.andcoe.recipeapp.recipe.view

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.andcoe.espresso.appContext
import org.andcoe.recipeapp.categoryrecipes.model.CategoryRecipeItem
import org.andcoe.robots.RecipeRobot
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RecipeActivityTest {

    @get:Rule
    var activityRule = ActivityTestRule(RecipeActivity::class.java, false, false)

    private val recipeRobot = RecipeRobot()

    @Test
    fun lunchesCategoryList() {
        val categoryRecipeItem = CategoryRecipeItem("1", "Tomato and pesto spaghetti", "some url")
        val intent = RecipeActivity.createStartIntent(appContext(), categoryRecipeItem)
        activityRule.launchActivity(intent)
        recipeRobot.checkTitleIsDisplayed("Tomato and pesto spaghetti")
        recipeRobot.checkImageIsDisplayed()
        recipeRobot.checkInstructions("some cooking instructions")
        recipeRobot.takeScreenshot(activityRule.activity)
    }

}