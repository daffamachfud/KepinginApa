package com.daffa.kepinginapa.utils

import android.content.Context

internal class AppPreference(context: Context) {
    companion object {
        private const val PREF_NAME = "app_preference"
        private const val LANDING_PAGE = "landing_page"
    }

    private val preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun setLandingPage(value: Boolean) {
        val pref = preferences.edit()
        pref.putBoolean(LANDING_PAGE, value)
        pref.apply()
    }

    fun getLandingPage(): Boolean {
        return preferences.getBoolean(LANDING_PAGE, true)
    }

}