package com.sammorton11.mathgame.pages
import com.sammorton11.mathgame.R
import com.sammorton11.mathgame.tests.BaseTest

open class ResultsPage : BaseTest() {

    fun getPlayAgainButton(): Int {
        return R.id.buttonPlayAgain
    }

    fun getExitButton(): Int {
        return R.id.buttonExit
    }

    fun getCongratulationsTextView(): Int {
        return R.id.congratsTextLabel
    }

    fun getResultScoreTextView(): Int {
        return R.id.textViewResultScore
    }
}