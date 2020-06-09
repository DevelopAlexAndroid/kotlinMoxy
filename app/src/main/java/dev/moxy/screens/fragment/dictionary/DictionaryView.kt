package dev.moxy.screens.fragment.dictionary

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType


interface DictionaryView : MvpView {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun translate()
}