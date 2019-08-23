package dev.moxy.repository.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import dev.moxy.repository.model.mNote
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface NoteDao {

    @Query("SELECT * FROM mNote")
    fun getAll(): Single<List<mNote>>

    @Insert
    fun insert(mNote: mNote): Long

}