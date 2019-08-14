package dev.moxy.screens.fragment.addedWord

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import dev.moxy.R

class AddedWordFragment : MvpAppCompatFragment(), AddedWordView {
    @InjectPresenter
    lateinit var addedWordPresenter: AddedWordPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        addedWordPresenter.createWord()
        return inflater.inflate(R.layout.fragment_added_word, container, false)
    }

    override fun addedWord() {
    }
}
