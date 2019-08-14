package dev.moxy

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import dev.moxy.App.Companion.TAG

@InjectViewState
class MainPresenter(var name: String) : MvpPresenter<MainView>() {
    fun print(){
        viewState.print()
        Log.d(TAG, name)
    }
}