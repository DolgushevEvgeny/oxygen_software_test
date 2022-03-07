package com.example.oxygensoftwaretestapp

import android.app.Application
import com.example.oxygensoftwaretestapp.di.ApplicationDICompanion

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        ApplicationDICompanion.init(this)
    }
}