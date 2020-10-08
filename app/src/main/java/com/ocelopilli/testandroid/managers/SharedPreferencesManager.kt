package com.ocelopilli.testandroid.managers

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesManager (context: Context) {
    val PREFS_NAME = "com.android.var"
    val SHARED_LOGIN = "shared_login"
    /*val SHARED_EMAIL = "shared_email"
    val SHARED_PASSWORD = "shared_password"*/
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, 0)

    var login: Boolean?
        get() = prefs.getBoolean(SHARED_LOGIN, false)
        set(value) = prefs.edit().putBoolean(SHARED_LOGIN, value!!).apply()

    /*var emailLogin: String?
        get() = prefs.getString(SHARED_EMAIL, "")
        set(value) = prefs.edit().putString(SHARED_EMAIL, value!!).apply()

    var passwordLogin: String?
        get() = prefs.getString(SHARED_PASSWORD, "")
        set(value) = prefs.edit().putString(SHARED_PASSWORD, value!!).apply()*/
}