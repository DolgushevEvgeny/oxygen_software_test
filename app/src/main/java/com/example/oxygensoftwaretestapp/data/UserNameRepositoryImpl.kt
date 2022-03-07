package com.example.oxygensoftwaretestapp.data

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import com.example.oxygensoftwaretestapp.domain.IUserNameRepository

class UserNameRepositoryImpl(private val writableBD: SQLiteDatabase) : IUserNameRepository {
    override fun saveInstUsername(cv: ContentValues) {
        writableBD.replace("User", null, cv)
    }
}