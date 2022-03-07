package com.example.oxygensoftwaretestapp.domain

import android.content.ContentValues

interface IUserNameRepository {

    fun saveInstUsername(cv: ContentValues)
}