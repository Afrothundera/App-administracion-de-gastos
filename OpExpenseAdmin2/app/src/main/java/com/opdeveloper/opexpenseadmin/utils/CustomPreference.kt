package com.opdeveloper.opexpenseadmin.utils

import android.content.Context
import android.content.SharedPreferences

class CustomPreference {
    lateinit var preferences: SharedPreferences
    lateinit var editor : SharedPreferences.Editor

    private val PREF_CALCULATOR : String = "OpExpense"
    private val FIRST_LAUNCH = "First_Launch"




    constructor(context: Context)  {
        preferences = context.getSharedPreferences(PREF_CALCULATOR,0)
        editor = preferences.edit()
    }

    open fun setFirstTimeLaunch(isFirstTime: Boolean) {
        editor.putBoolean(FIRST_LAUNCH, isFirstTime)
        editor.commit()
    }

    open fun isFirstTimeLaunched(): Boolean {
        return preferences.getBoolean(FIRST_LAUNCH, false)
    }



}