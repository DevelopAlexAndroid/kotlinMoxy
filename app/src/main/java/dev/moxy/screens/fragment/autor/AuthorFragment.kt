package dev.moxy.screens.fragment.autor

import android.os.Bundle
import android.view.View
import dev.moxy.R
import dev.moxy.screens.activity.OnBackPressed
import kotlinx.android.synthetic.main.fragment_author.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class AuthorFragment : MvpAppCompatFragment(R.layout.fragment_author), AuthorView,OnBackPressed {

    @InjectPresenter
    lateinit var presenter: AuthorPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        but_back_to.setOnClickListener {
            presenter.backToTranslate()
        }
        im_avatar.setOnClickListener {
            //change ava
        }
    }

    override fun onBackPressed() {
        presenter.onBack()
    }

}