package org.andcoe.robots

import androidx.appcompat.app.AppCompatActivity
import com.facebook.testing.screenshot.Screenshot

abstract class BaseRobot {

    fun takeScreenshot(activity: AppCompatActivity,
                       name: String = activity::class.java.simpleName) {
        Screenshot
            .snapActivity(activity)
            .setName(name)
            .record()
    }
}
