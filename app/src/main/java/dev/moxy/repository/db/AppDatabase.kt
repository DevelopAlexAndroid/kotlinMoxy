package dev.moxy.repository.db

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.moxy.repository.model.mNote

@Database(entities = [mNote::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}