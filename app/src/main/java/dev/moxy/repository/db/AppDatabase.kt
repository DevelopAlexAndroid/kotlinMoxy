package dev.moxy.repository.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import dev.moxy.repository.model.mNote

@Database(entities = [mNote::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}