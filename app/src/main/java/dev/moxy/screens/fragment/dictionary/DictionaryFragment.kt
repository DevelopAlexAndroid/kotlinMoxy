package dev.moxy.screens.fragment.dictionary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.moxy.R
import dev.moxy.adapters.AddedWordAdapter
import dev.moxy.repository.model.mNote
import dev.moxy.screens.activity.OnBackPressed
import kotlinx.android.synthetic.main.fragment_dictionary.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class DictionaryFragment : MvpAppCompatFragment(), DictionaryView,
    OnBackPressed {
    @InjectPresenter
    lateinit var dictionaryPresenter: DictionaryPresenter

    private lateinit var addedWordAdapter: AddedWordAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dictionary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        replace.setOnClickListener {
            dictionaryPresenter.onReplace()
        }

        dictionaryPresenter.createWordList()
    }

    override fun showWords(words: List<mNote>) {
        addedWordAdapter = AddedWordAdapter(words)
        wordList.adapter = addedWordAdapter
    }

    override fun onBackPressed() {
        dictionaryPresenter.onBack()
    }
}
