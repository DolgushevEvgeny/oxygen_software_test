package com.example.oxygensoftwaretestapp.domain

import android.content.ContentValues
import android.database.Cursor

interface IUserNameRepository {

    fun saveInstUsername(cv: ContentValues)

    fun getInstUserName(): Cursor
}