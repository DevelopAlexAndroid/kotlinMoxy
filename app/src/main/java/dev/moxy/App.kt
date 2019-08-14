package dev.moxy

import android.app.Application
import android.util.Log

class App : Application() {

    companion object{
        var TAG = "kotlinMoxy"
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreateApp")
    }
}