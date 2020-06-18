package dev.moxy.screens.fragment.autor

import dev.moxy.App
import dev.moxy.Screens
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class AuthorPresenter : MvpPresenter<AuthorView>() {

    private var router: Router = App.cicerone.router

    fun backToTranslate() {
        router.backTo(Screens.AddedWord)
    }

    fun onBack() {
        router.exit()
    }
}