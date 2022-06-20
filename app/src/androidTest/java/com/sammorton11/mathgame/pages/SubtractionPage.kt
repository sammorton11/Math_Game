package com.sammorton11.mathgame.pages

import com.sammorton11.mathgame.R
import com.sammorton11.mathgame.tests.BaseTest

open class SubtractionPage : BaseTest() {

    fun getQuestionTextView(): Int{
        return R.id.textViewQuestion
    }

    fun getAnswerEditField(): Int{
        return R.id.editTextAnswer
    }

    fun getOkButton(): Int{
        return R.id.buttonOk
    }

    fun getNextButton(): Int{
        return R.id.buttonNext
    }


    fun getScoreTextLabel(): Int {
        return R.id.textLabelScore
    }

    fun getScoreNumberTextView(): Int {
        return R.id.textViewScoreNumber
    }

    fun getLifeTextLabel(): Int {
        return R.id.lifeTextLabel
    }

    fun getLifeNumberTextView(): Int {
        return R.id.textViewLife
    }

    fun getTimeTextLabel(): Int {
        return R.id.timeTextLabel
    }

    fun getTimeNumberTextView(): Int {
        return R.id.textViewTime
    }


}