package com.example.oxygensoftwaretestapp

import android.content.Context
import android.provider.Settings

fun Context.isAccessibilityServiceEnabled(accessibilityServiceClass: Class<*>): Boolean {
    val prefString = Settings.Secure.getString(
        contentResolver,
        Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES
    )
    return prefString.contains(packageName + "/" + accessibilityServiceClass.name)
}