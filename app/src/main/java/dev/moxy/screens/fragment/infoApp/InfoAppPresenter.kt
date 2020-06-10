package dev.moxy.screens.fragment.infoApp

import dev.moxy.App
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class InfoAppPresenter : MvpPresenter<InfoAppView>() {

    private var router: Router = App.cicerone.router

    fun onBack() {
        router.exit()
    }

}