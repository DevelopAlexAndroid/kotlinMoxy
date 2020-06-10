package dev.moxy.screens.fragment.addedWord

import android.util.Log
import dev.moxy.App
import dev.moxy.App.Companion.TAG
import dev.moxy.Screens
import dev.moxy.repository.addedWordRepository.AddedWordRepositoryImpl
import dev.moxy.repository.model.mNote
import io.reactivex.Completable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class AddedWordPresenter : MvpPresenter<AddedWordView>() {

    private val repositoryImpl = AddedWordRepositoryImpl()
    private val compositeDisposable = CompositeDisposable()
    private var router: Router = App.cicerone.router

    fun onForward() {
        router.navigateTo(Screens.Dictionary)
    }

    fun onBack() {
        router.exit()
    }

    fun addNewWord(mNote: mNote) {
        compositeDisposable.add(Completable
            .fromRunnable {
                repositoryImpl.addNote(mNote)
            }
            .subscribeOn(Schedulers.io()).subscribe {
                Log.d(TAG, "added ")
            })
    }

    fun fixWordTranslate(translate: String, id: Int) {
        repositoryImpl.fixNote(translate, id)
    }

    fun deleteWord(id: Int) {
        repositoryImpl.deleteNote(id)
    }
}