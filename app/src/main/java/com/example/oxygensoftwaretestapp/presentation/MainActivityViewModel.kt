package com.example.oxygensoftwaretestapp.presentation

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModel
import com.example.oxygensoftwaretestapp.presentation.MainActivity

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