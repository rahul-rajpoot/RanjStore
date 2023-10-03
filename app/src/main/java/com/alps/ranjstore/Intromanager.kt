package com.alps.ranjstore.com.alps.ranjstore

import android.content.Context
import android.content.SharedPreferences

class Intromanager(var context: Context) {
    var pref: SharedPreferences
    var editor: SharedPreferences.Editor

    init {
        pref = context.getSharedPreferences("first", 0)
        editor = pref.edit()
    }

    fun setFirst(isFirst: Boolean) {
        editor.putBoolean("check", isFirst)
        editor.commit()
    }

    fun Check(): Boolean {
        return pref.getBoolean("check", true)
    }
}