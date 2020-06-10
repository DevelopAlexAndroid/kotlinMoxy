package dev.moxy.screens.fragment.dictionary

import dev.moxy.App
import dev.moxy.Screens
import dev.moxy.repository.addedWordRepository.AddedWordRepositoryImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router


@InjectViewState
class DictionaryPresenter : MvpPresenter<DictionaryView>() {

    private var router: Router = App.cicerone.router
    private val compositeDisposable = CompositeDisposable()
    private val repositoryImpl = AddedWordRepositoryImpl()

    fun onReplace() {
        router.replaceScreen(Screens.AddedWord)
    }

    fun onBack() {
        router.exit()
    }

    fun createWordList() {
        compositeDisposable.add(repositoryImpl.getListNote()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { list ->
                viewState.showWords(list)
            })
    }

}