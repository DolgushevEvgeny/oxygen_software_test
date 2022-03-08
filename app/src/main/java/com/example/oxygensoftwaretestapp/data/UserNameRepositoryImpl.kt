package com.example.oxygensoftwaretestapp.data

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.oxygensoftwaretestapp.domain.IUserNameRepository

class UserNameRepositoryImpl(private val writableBD: SQLiteDatabase) : IUserNameRepository {
    override fun saveInstUsername(cv: ContentValues) {
        writableBD.replace(USERNAME_TABLE, null, cv)
    }

    override fun getInstUserName(): Cursor {
        return writableBD.query(
            USERNAME_TABLE, null, "id == ?",
            listOf("1").toTypedArray(), null, null, null
        )
    }

    companion object {
        private const val USERNAME_TABLE = "User"
    }
}