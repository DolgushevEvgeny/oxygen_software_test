package com.example.oxygensoftwaretestapp

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import com.example.oxygensoftwaretestapp.di.MainActivityDICompanion
import com.example.oxygensoftwaretestapp.domain.models.SaveInstUserNameParams

class InstagramAccessibilityService : AccessibilityService() {

    private val mSaveInstUserNameUseCase by lazy {
        MainActivityDICompanion.saveInstUserNameUseCase
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        if (event == null) {
            return
        }
        if (event.eventType == AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED) {
            if (!isProfileClicked) {
                val list = event.source.findAccessibilityNodeInfosByViewId(PROFILE_TAB_VIEW_ID)
                if (list.isNotEmpty()) {
                    val profileTabView = list.first()
                    profileTabView.performAction(AccessibilityNodeInfo.ACTION_CLICK)
                    isProfileClicked = true
                }
            }
            if (!isAccountNameFound) {
                val list = event.source.findAccessibilityNodeInfosByViewId(NICKNAME_VIEW_ID)
                if (list.isNotEmpty()) {
                    val accountNameView = list.first()
                    val params = SaveInstUserNameParams(accountNameView.text.toString())
                    mSaveInstUserNameUseCase.execute(params)
                    isAccountNameFound = true
                }
            }
        }
    }

    override fun onInterrupt() {

    }

    companion object {
        private const val PROFILE_TAB_VIEW_ID = "com.instagram.android:id/profile_tab"
        private const val NICKNAME_VIEW_ID =
            "com.instagram.android:id/action_bar_large_title_auto_size"
        private var isProfileClicked = false
        private var isAccountNameFound = false
    }
}