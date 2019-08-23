package dev.moxy.screens.fragment.addedWord

import com.arellomobile.mvp.MvpView
import dev.moxy.repository.model.mNote

interface AddedWordView : MvpView {
    fun showWords(wordList: List<mNote>)
}