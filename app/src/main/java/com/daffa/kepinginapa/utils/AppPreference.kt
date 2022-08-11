package com.daffa.kepinginapa.utils

import android.content.Context
import android.preference.PreferenceManager

internal class AppPreference(context: Context) {
    companion object {
        private const val LANDING_PAGE = "landing_page"
    }

    private val preferences = PreferenceManager.getDefaultSharedPreferences(context)

    fun setLandingPage(value: Boolean) {
        val pref = preferences.edit()
        pref.putBoolean(LANDING_PAGE, value)
        pref.apply()
    }

    fun getLandingPage(): Boolean {
        return preferences.getBoolean(LANDING_PAGE, true)
    }

}