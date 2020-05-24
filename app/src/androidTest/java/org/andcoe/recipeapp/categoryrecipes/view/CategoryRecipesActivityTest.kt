package org.andcoe.recipeapp.categoryrecipes.view

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.andcoe.espresso.appContext
import org.andcoe.recipeapp.categories.view.CategoryItem
import org.andcoe.robots.CategoryRecipesRobot
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CategoryRecipesActivityTest {

    @get:Rule
    var activityRule = ActivityTestRule(CategoryRecipesActivity::class.java, false, false)

    private val categoryRecipesRobot = CategoryRecipesRobot()

    @Test
    fun lunchesCategoryList() {
        val intent = CategoryRecipesActivity.createStartIntent(appContext(), CategoryItem("Pasta"))
        activityRule.launchActivity(intent)
        categoryRecipesRobot.checkTitleIsDisplayed()
        categoryRecipesRobot.checkCategoryNameIsDisplayed("Pasta")
    }

}