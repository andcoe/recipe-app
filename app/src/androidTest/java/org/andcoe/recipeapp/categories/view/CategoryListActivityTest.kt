package org.andcoe.recipeapp.categories.view

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.andcoe.robots.CategoryListRobot
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CategoryListActivityTest {

    @get:Rule
    var activityRule = ActivityTestRule(CategoryListActivity::class.java)

    private val categoryListRobot = CategoryListRobot()

    @Test
    fun lunchesCategoryList() {
        categoryListRobot.checkTitleIsDisplayed()
        categoryListRobot.checkListIsDisplayed()
    }

}