package com.example.oxygensoftwaretestapp.presentation

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.oxygensoftwaretestapp.domain.models.UserName
import com.example.oxygensoftwaretestapp.domain.useCase.GetInstUserNameUseCase

class MainActivityViewModel(
    private val getInstUserNameUseCase: GetInstUserNameUseCase
) : ViewModel() {

    val usernameLiveData: LiveData<UserName>
        get() = mUsernameLiveData

    private val mUsernameLiveData: MutableLiveData<UserName> = MutableLiveData()

    init {
        mUsernameLiveData.value = getInstUserNameUseCase.execute()
    }

    fun getInstagramNickName(activity: MainActivity) {
        val instagramIntent = Intent(Intent.ACTION_VIEW)
        instagramIntent.`package` = "com.instagram.android"
        instagramIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

        try {
            activity.startActivity(instagramIntent)
        } catch (e: ActivityNotFoundException) {

        }
    }
}