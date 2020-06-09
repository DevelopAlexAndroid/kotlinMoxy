package dev.moxy.screens.fragment.dictionary

import moxy.InjectViewState
import moxy.MvpPresenter


@InjectViewState
class DictionaryPresenter : MvpPresenter<DictionaryView>() {
    fun createList() {
        viewState.translate()
    }
}