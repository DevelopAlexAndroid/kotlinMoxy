package dev.moxy

import android.os.Bundle
import android.util.Log
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import dev.moxy.App.Companion.TAG

class MainActivity : MvpAppCompatActivity(), MainView {

    @InjectPresenter
    lateinit var mainPresenter: MainPresenter

    @ProvidePresenter
    fun provideDetailsPresenter(): MainPresenter {
        return MainPresenter("it's const in activity")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainPresenter.print()
    }

    override fun print() {
        Log.d(TAG, "PRINT")
    }
}
