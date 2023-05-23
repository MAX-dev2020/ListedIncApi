package com.example.listedinternship

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

class MyApplication : Application() {

    companion object {
        private const val PREFS_NAME = "MyAppPrefs"
        private const val TOKEN_KEY = "token"

        private lateinit var sharedPreferences: SharedPreferences

        private var token: String = ""

        fun saveToken() {
            this.token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MjU5MjcsImlhdCI6MTY3NDU1MDQ1MH0.dCkW0ox8tbjJA2GgUx2UEwNlbTZ7Rr38PVFJevYcXFI"
            sharedPreferences.edit().putString(TOKEN_KEY, token).apply()
        }

        fun getToken(): String {
            return token.ifEmpty {
                sharedPreferences.getString(TOKEN_KEY, "") ?: ""
            }
        }
    }

    override fun onCreate() {
        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        saveToken()
        super.onCreate()
    }
}
