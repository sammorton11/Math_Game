package com.sammorton11.mathgame.tests
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sammorton11.mathgame.MainActivity
import com.sammorton11.mathgame.R
import com.sammorton11.mathgame.pages.ResultsPage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.sammorton11.mathgame.ResultActivity

@RunWith(AndroidJUnit4::class)
class ResultsPageTest : ResultsPage()  {

    @get:Rule
    val activityTestRule = ActivityScenarioRule(ResultActivity::class.java)

    @Test
    fun clickPlayAgainButton(){
        clickButton(getPlayAgainButton())
    }

    @Test
    fun clickExitGameButton(){
        clickButton(getExitButton())
    }

    @Test
    fun checkTextViewVisibility(){
        checkVisibility(getPlayAgainButton())
        checkVisibility(getExitButton())
        checkVisibility(getCongratulationsTextView())
        checkVisibility(getResultScoreTextView())
    }
}