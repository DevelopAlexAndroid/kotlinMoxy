package dev.moxy.screens.fragment.infoApp

import android.os.Bundle
import android.view.View
import dev.moxy.R
import dev.moxy.screens.activity.OnBackPressed
import kotlinx.android.synthetic.main.fragment_info_app.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter


class InfoAppFragment : MvpAppCompatFragment(R.layout.fragment_info_app), InfoAppView,
    OnBackPressed {

    @InjectPresenter
    lateinit var presenter: InfoAppPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        but_autor.setOnClickListener {
            presenter.navigateToAuthor()
        }

    }

    override fun onBackPressed() {
        presenter.onBack()
    }

}