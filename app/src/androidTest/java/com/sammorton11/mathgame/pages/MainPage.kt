package com.sammorton11.mathgame.pages
import com.sammorton11.mathgame.R
import com.sammorton11.mathgame.tests.BaseTest

open class MainPage : BaseTest(){

    fun getAdditionGameButton(): Int {
        return R.id.buttonAdd
    }

    fun getSubtractionGameButton(): Int {
        return R.id.buttonSub
    }

    fun getMultiplicationGameButton(): Int {
        return R.id.buttonMulti
    }
}