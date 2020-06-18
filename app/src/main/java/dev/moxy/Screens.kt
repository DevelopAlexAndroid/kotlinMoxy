package dev.moxy

import dev.moxy.screens.fragment.addedWord.AddedWordFragment
import dev.moxy.screens.fragment.autor.AuthorFragment
import dev.moxy.screens.fragment.dictionary.DictionaryFragment
import dev.moxy.screens.fragment.infoApp.InfoAppFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {
    object AddedWord : SupportAppScreen() {
        override fun getFragment() = AddedWordFragment()
    }

    object Dictionary : SupportAppScreen() {
        override fun getFragment() = DictionaryFragment()
    }

    object InfoApp : SupportAppScreen() {
        override fun getFragment() = InfoAppFragment()
    }

    object AuthorFragment : SupportAppScreen() {
        override fun getFragment() = AuthorFragment()
    }
}