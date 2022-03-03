package com.example.oxygensoftwaretestapp

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    init {

    }

    fun getInstagramNickName(activity: MainActivity) {
        val instagramIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com"))
        instagramIntent.`package` = "com.instagram.android"

        try {
            activity.startActivity(instagramIntent)
        } catch (e: ActivityNotFoundException) {
            
        }
    }
}