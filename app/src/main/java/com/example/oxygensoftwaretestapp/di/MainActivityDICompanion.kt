package com.example.oxygensoftwaretestapp.di

import android.content.Context
import com.example.oxygensoftwaretestapp.DBHelper
import com.example.oxygensoftwaretestapp.data.UserNameRepositoryImpl
import com.example.oxygensoftwaretestapp.domain.IUserNameRepository
import com.example.oxygensoftwaretestapp.domain.useCase.SaveInstUserNameUseCase

object MainActivityDICompanion {

    val applicationContext: Context
        get() = mApplicationContext
    val dbHelper: DBHelper
        get() = mDBHelper
    val saveInstUserNameUseCase: SaveInstUserNameUseCase by lazy {
        SaveInstUserNameUseCase(usernameRepository)
    }

    private val mDBHelper: DBHelper by lazy {
        DBHelper(mApplicationContext)
    }
    private lateinit var mApplicationContext: Context
    private lateinit var usernameRepository: IUserNameRepository

    fun init(
        applicationContext: Context,
    ) {
        mApplicationContext = applicationContext
        usernameRepository = UserNameRepositoryImpl(dbHelper.writableDatabase)
    }
}