package dev.moxy.screens.fragment.addedWord

import android.os.Bundle
import android.support.v7.widget.LinearLayoutCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import dev.moxy.R
import dev.moxy.adapters.AddedWordAdapter
import dev.moxy.repository.model.mNote
import kotlinx.android.synthetic.main.fragment_added_word.*

class AddedWordFragment : MvpAppCompatFragment(), AddedWordView {

    @InjectPresenter
    lateinit var addedWordPresenter: AddedWordPresenter

    private lateinit var addedWordAdapter: AddedWordAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_added_word, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        wordList.layoutManager = LinearLayoutManager(activity)
        addedWordPresenter.createWordList()
        addedWordPresenter.addNewWord(mNote(head = "123", text = "sadsa"))
    }

    override fun showWords(words: List<mNote>) {
        addedWordAdapter = AddedWordAdapter(words)
        wordList.adapter = addedWordAdapter
    }
}
