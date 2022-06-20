package com.sammorton11.mathgame.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sammorton11.mathgame.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.sammorton11.mathgame.pages.MainPage

@RunWith(AndroidJUnit4::class)
class MainPageTest : MainPage() {

    @get:Rule
    val activityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun clickAdditionGameButton(){
        checkVisibility(getAdditionGameButton())
        clickButton(getAdditionGameButton())
    }

    @Test
    fun clickSubtractionGameButton(){
        checkVisibility(getSubtractionGameButton())
        clickButton(getSubtractionGameButton())
    }

    @Test
    fun clickMultiplicationGameButton(){
        checkVisibility(getMultiplicationGameButton())
        clickButton(getMultiplicationGameButton())
    }

}