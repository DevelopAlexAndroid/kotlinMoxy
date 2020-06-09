package dev.moxy

import android.app.Application
import android.util.Log
import androidx.room.Room
import dev.moxy.repository.db.AppDatabase
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

class App : Application() {

    companion object {
        var TAG = "kotlinMoxy"
        lateinit var appDatabase: AppDatabase
        lateinit var App: Application
    }

    private lateinit var cicerone: Cicerone<Router>

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreateApp")

        App = this
        cicerone = Cicerone.create()

        appDatabase = Room
            .databaseBuilder(this, AppDatabase::class.java, "database")
            .build()

    }

    public fun getRouter(): Router {
        return cicerone.router
    }

    public fun getNavigationHolder(): NavigatorHolder {
        return cicerone.navigatorHolder
    }
}