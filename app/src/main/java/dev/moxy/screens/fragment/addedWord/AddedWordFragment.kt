package dev.moxy.screens.fragment.addedWord

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import dev.moxy.R
import dev.moxy.repository.model.mNote
import dev.moxy.screens.activity.OnBackPressed
import kotlinx.android.synthetic.main.fragment_added_word.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class AddedWordFragment : MvpAppCompatFragment(), AddedWordView,
    OnBackPressed {

    @InjectPresenter
    lateinit var addedWordPresenter: AddedWordPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_added_word, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        check_dictionary.setOnClickListener {
            addedWordPresenter.onForward()
        }

        but_save.setOnClickListener {
            val note =
                mNote(text = word.text.toString(), translate = word_translate.text.toString())
            addedWordPresenter.addNewWord(note)
        }
    }

    override fun savedWord() {
        Toast.makeText(activity, "Word SAVED", Toast.LENGTH_SHORT).show()
    }

    override fun onBackPressed() {
        addedWordPresenter.onBack()
    }
}
