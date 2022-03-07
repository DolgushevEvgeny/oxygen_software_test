package com.example.oxygensoftwaretestapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context, version: Int = 1) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, version) {

    override fun onCreate(database: SQLiteDatabase?) {
        database?.execSQL("CREATE TABLE User (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT);");
    }

    override fun onUpgrade(database: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    companion object {
        private const val DATABASE_NAME = "oxygen_software"
    }
}