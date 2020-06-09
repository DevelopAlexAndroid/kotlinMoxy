package dev.moxy.screens.fragment.addedWord

import dev.moxy.repository.model.mNote
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface AddedWordView : MvpView {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showWords(wordList: List<mNote>)
}