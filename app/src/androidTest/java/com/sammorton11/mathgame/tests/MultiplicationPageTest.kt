package com.sammorton11.mathgame.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sammorton11.mathgame.R
import com.sammorton11.mathgame.SubGameActivity
import com.sammorton11.mathgame.pages.MultiplicationPage
import com.sammorton11.mathgame.MultiActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MultiplicationPageTest : MultiplicationPage() {

    @get:Rule
    val activityTestRule = ActivityScenarioRule(MultiActivity::class.java)

    @Test
    fun checkGameUIVisibility(){

        //Question Edit Field
        checkVisibility(getQuestionTextView())

        //Answer TextView
        checkVisibility(getAnswerEditField())

        //Ok Button
        checkVisibility(getOkButton())

        //Next Button
        checkVisibility(getNextButton())

    }

    @Test
    fun checkScoreLifeTimeTextViews(){

        //Score TextView and Label
        checkVisibility(getScoreNumberTextView())
        checkVisibility(getScoreTextLabel())

        //Life Amount and Label
        checkVisibility(getLifeTextLabel())
        checkVisibility(getLifeNumberTextView())

        //Time Amount and Label
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