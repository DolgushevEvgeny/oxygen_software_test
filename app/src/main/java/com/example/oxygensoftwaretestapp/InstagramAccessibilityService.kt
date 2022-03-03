package com.example.oxygensoftwaretestapp

import android.accessibilityservice.AccessibilityService
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo

class InstagramAccessibilityService : AccessibilityService() {

    override fun onCreate() {

    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        Log.d("Service: ", event.toString())
        Log.d("Service event.source: ", event?.source.toString())
        if (event == null) {
            return
        }
        if (event.eventType == AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED) {
            if (!isProfileClicked) {
                val profileView =
                    findViewByContentDescription(rootInActiveWindow, PROFILE_CONTENT_DESCRIPTION)
                profileView?.performAction(AccessibilityNodeInfo.ACTION_CLICK)
                isProfileClicked = true
            }
            if (!isAccountNameFound) {
                val accountNameView = null
            }
        }
    }

    override fun onInterrupt() {
        Log.d("Service", "onInterrupt")
    }

    private fun findViewByContentDescription(
        root: AccessibilityNodeInfo,
        contentDescription: String
    ): AccessibilityNodeInfo? {
        if (root.contentDescription == PROFILE_CONTENT_DESCRIPTION) {
            return root
        }
        for (index in 0 until root.childCount) {
            val view = findViewByContentDescription(root.getChild(index), contentDescription)
            if (view != null) {
                return view
            }
        }
        return null
    }

    companion object {
        private const val PROFILE_CONTENT_DESCRIPTION = "Profile"
        private var isProfileClicked = false
        private var isAccountNameFound = false
    }
}