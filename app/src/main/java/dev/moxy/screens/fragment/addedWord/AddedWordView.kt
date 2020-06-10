package dev.moxy.screens.fragment.addedWord

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface AddedWordView : MvpView {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun savedWord()
}