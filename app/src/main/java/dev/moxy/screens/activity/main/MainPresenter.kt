package dev.moxy.screens.activity.main

import android.util.Log
import dev.moxy.App
import dev.moxy.App.Companion.TAG
import dev.moxy.Screens
import dev.moxy.repository.model.mNote
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class MainPresenter(var name: String) : MvpPresenter<MainView>() {

    private lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        Log.d(TAG, name)
        router = App.cicerone.router
        router.navigateTo(Screens.AddedWord)
    }

}