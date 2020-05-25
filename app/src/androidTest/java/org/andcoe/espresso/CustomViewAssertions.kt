package org.andcoe.espresso

import androidx.annotation.StringRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.CoreMatchers.allOf

object CustomViewAssertions {

    fun checkTitleIsDisplayed(@StringRes titleResId: Int, param: String = "") {
        val resources = appContext().resources
        val titleText =
            resources.getString(titleResId, if (param.isNotEmpty()) param else emptyArray<String>())

        onView(
            allOf(
                withText(titleText),
                isDescendantOfA(withResourceName("action_bar"))
            )
        ).check(matches(isDisplayed()))
    }
}