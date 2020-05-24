package org.andcoe.espresso

import androidx.annotation.StringRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.CoreMatchers.allOf

object CustomViewAssertions {

    fun checkTitleIsDisplayed(@StringRes titleResId: Int) {
        val resources = appContext().resources
        onView(
            allOf(
                withText(resources.getString(titleResId)),
                isDescendantOfA(withResourceName("action_bar"))
            )
        ).check(matches(isDisplayed()))
    }
}