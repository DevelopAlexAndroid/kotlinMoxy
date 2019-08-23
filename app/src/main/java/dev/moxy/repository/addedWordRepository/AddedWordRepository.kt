package dev.moxy.repository.addedWordRepository

import dev.moxy.repository.model.mNote
import io.reactivex.Completable
import io.reactivex.Single

interface AddedWordRepository {
    fun addNote(mNote: mNote): Long
    fun fixNote(translate: String, id: Int)
    fun deleteNote(id: Int)
    fun getListNote(): Single<List<mNote>>
}