package dev.moxy

import android.app.Application
import android.arch.persistence.room.Room
import android.util.Log
import dev.moxy.repository.db.AppDatabase

class App : Application() {

    companion object{
        var TAG = "kotlinMoxy"
        lateinit var appDatabase: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreateApp")

        appDatabase = Room
            .databaseBuilder(this, AppDatabase::class.java, "database")
            .build()

    }
}