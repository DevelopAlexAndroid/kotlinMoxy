package dev.moxy.screens.fragment.addedWord

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

@InjectViewState
class AddedWordPresenter : MvpPresenter<AddedWordView>() {
    fun createWord() {
        viewState.addedWord()
    }
}