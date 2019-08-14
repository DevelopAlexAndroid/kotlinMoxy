package dev.moxy.screens.fragment.dictionary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import dev.moxy.R

class DictionaryFragment : MvpAppCompatFragment(), DictionaryView {
    @InjectPresenter
    lateinit var dictionaryPresenter: DictionaryPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dictionaryPresenter.createList()
        return inflater.inflate(R.layout.fragment_dictionary, container, false)
    }

    override fun translate() {
    }
}
