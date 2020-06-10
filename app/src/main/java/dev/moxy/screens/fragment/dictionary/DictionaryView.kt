package dev.moxy.screens.fragment.dictionary

import dev.moxy.repository.model.mNote
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType


interface DictionaryView : MvpView {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showWords(wordList: List<mNote>)
}