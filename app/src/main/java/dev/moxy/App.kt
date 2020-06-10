package dev.moxy

import android.app.Application
import android.util.Log
import androidx.room.Room
import dev.moxy.repository.db.AppDatabase
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

class App : Application() {

    companion object {
        var TAG = "kotlinMoxy"
        lateinit var appDatabase: AppDatabase
        lateinit var INSTANCE: Application
        lateinit var cicerone: Cicerone<Router>
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreateApp")

        INSTANCE = this
        cicerone = Cicerone.create()

        appDatabase = Room
            .databaseBuilder(this, AppDatabase::class.java, "database")
            .build()

    }
}