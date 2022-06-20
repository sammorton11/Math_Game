package com.sammorton11.mathgame.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sammorton11.mathgame.R
import com.sammorton11.mathgame.SubGameActivity
import com.sammorton11.mathgame.pages.SubtractionPage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SubtractionPageTest : SubtractionPage() {

    @get:Rule
    val activityTestRule = ActivityScenarioRule(SubGameActivity::class.java)

    @Test
    fun checkGameUIVisibility(){

        checkVisibility(getQuestionTextView())

        checkVisibility(getAnswerEditField())

        checkVisibility(getOkButton())

        checkVisibility(getNextButton())

    }

    @Test
    fun checkScoreLifeTimeTextViews(){

        checkVisibility(getScoreNumberTextView())
        checkVisibility(getScoreTextLabel())

        checkVisibility(getLifeTextLabel())
        checkVisibility(getLifeNumberTextView())

        checkVisibility(getTimeTextLabel())
        checkVisibility(getTimeNumberTextView())
    }

    @Test
    fun checkCorrectAnswer(){
        typeInText(getAnswerEditField(), testAnswer)
        clickButton(getOkButton())
        checkTextVisibility(R.string.correctAnswerText)
    }

    @Test
    fun checkIncorrectAnswer(){
        typeInText(getAnswerEditField(), testIncorrectAnswer)
        clickButton(getOkButton())
        checkTextVisibility(R.string.incorrectAnswerText)
    }
}