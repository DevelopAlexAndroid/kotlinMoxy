package dev.moxy.repository.addedWordRepository

import dev.moxy.App
import dev.moxy.repository.model.mNote
import io.reactivex.Completable
import io.reactivex.Single

class AddedWordRepositoryImpl : AddedWordRepository{

    private var noteDao = App.appDatabase.noteDao()

    override fun getListNote(): Single<List<mNote>> {
        val noteList = noteDao.getAll()
        return noteList
    }

    override fun fixNote(translate: String, id: Int) {

    }

    override fun deleteNote(id: Int) {

    }

    override fun addNote(mNote: mNote): Long {
        return noteDao.insert(mNote)
    }
}