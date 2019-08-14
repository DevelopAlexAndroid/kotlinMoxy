package dev.moxy.screens.fragment.dictionary

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

@InjectViewState
class DictionaryPresenter : MvpPresenter<DictionaryView>() {
    fun createList() {
        viewState.translate()
    }
}