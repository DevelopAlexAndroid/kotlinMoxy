package dev.moxy.screens.activity.main

import android.util.Log
import dev.moxy.App
import dev.moxy.App.Companion.TAG
import dev.moxy.repository.model.mNote
import moxy.MvpPresenter

class MainPresenter(var name: String) : MvpPresenter<MainView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

    }

    fun print(){
        viewState.print()
        Log.d(TAG, name)
    }

    fun addNote(mNote: mNote){
        App.appDatabase.noteDao().insert(mNote)
    }

    /*fun getList(): List<mNote>{
        return App.appDatabase.noteDao().getAll()
    }*/
}