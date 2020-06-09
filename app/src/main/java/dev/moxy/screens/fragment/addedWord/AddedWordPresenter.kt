package dev.moxy.screens.fragment.addedWord

import android.util.Log
import dev.moxy.App.Companion.TAG
import dev.moxy.R
import dev.moxy.repository.addedWordRepository.AddedWordRepositoryImpl
import dev.moxy.repository.model.mNote
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class AddedWordPresenter : MvpPresenter<AddedWordView>() {

    private val repositoryImpl = AddedWordRepositoryImpl()
    private val compositeDisposable = CompositeDisposable()

    fun addNewWord(mNote: mNote) {
        var d = Completable
            .fromRunnable {
                repositoryImpl.addNote(mNote)
            }
            .subscribeOn(Schedulers.io()).subscribe {
                Log.d(TAG, "added ")
            }
    }

    fun createWordList() {
        compositeDisposable.add(repositoryImpl.getListNote()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { list ->
                viewState.showWords(list)
            })
    }

    fun fixWordTranslate(translate: String, id: Int) {
        repositoryImpl.fixNote(translate, id)
    }

    fun deleteWord(id: Int) {
        repositoryImpl.deleteNote(id)
    }
}