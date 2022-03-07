package com.example.oxygensoftwaretestapp.di

import android.content.Context

object ApplicationDICompanion {

    val applicationContext: Context
        get() = mApplicationContext

    private lateinit var mApplicationContext: Context

    fun init(
        applicationContext: Context
    ) {
        mApplicationContext = applicationContext

        MainActivityDICompanion.init(
            applicationContext = applicationContext,

            )
    }
}