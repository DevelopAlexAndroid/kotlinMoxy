package dev.moxy.screens.fragment.infoApp

import dev.moxy.App
import dev.moxy.Screens
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class InfoAppPresenter : MvpPresenter<InfoAppView>() {

    private var router: Router = App.cicerone.router

    fun navigateToAuthor() {
        router.navigateTo(Screens.AuthorFragment)
    }

    fun onBack() {
        router.exit()
    }

}