package com.example.oxygensoftwaretestapp.di

import android.content.Context
import com.example.oxygensoftwaretestapp.DBHelper
import com.example.oxygensoftwaretestapp.data.UserNameRepositoryImpl
import com.example.oxygensoftwaretestapp.domain.IUserNameRepository
import com.example.oxygensoftwaretestapp.domain.useCase.GetInstUserNameUseCase
import com.example.oxygensoftwaretestapp.domain.useCase.SaveInstUserNameUseCase

object MainActivityDICompanion {

    val applicationContext: Context
        get() = mApplicationContext
    val dbHelper: DBHelper
        get() = mDBHelper
    val saveInstUserNameUseCase: SaveInstUserNameUseCase by lazy {
        SaveInstUserNameUseCase(mUsernameRepository)
    }
    val getInstUserNameUseCase: GetInstUserNameUseCase by lazy {
        GetInstUserNameUseCase(mUsernameRepository)
    }

    private val mDBHelper: DBHelper by lazy {
        DBHelper(mApplicationContext)
    }
    private lateinit var mApplicationContext: Context
    private lateinit var mUsernameRepository: IUserNameRepository

    fun init(
        applicationContext: Context,
    ) {
        mApplicationContext = applicationContext
        mUsernameRepository = UserNameRepositoryImpl(dbHelper.writableDatabase)
    }
}