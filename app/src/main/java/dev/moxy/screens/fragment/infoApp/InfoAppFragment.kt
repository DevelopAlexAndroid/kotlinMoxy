package dev.moxy.screens.fragment.infoApp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.moxy.R
import dev.moxy.screens.activity.OnBackPressed
import dev.moxy.screens.fragment.dictionary.DictionaryPresenter
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter


class InfoAppFragment : MvpAppCompatFragment(), InfoAppView, OnBackPressed {

    @InjectPresenter
    lateinit var presenter: InfoAppPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_info_app, container, false)
    }

    override fun onBackPressed() {
        presenter.onBack()
    }

}