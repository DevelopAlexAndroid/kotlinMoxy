package dev.moxy.repository.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
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