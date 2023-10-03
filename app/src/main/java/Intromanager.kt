package com.alps.ranjstore

import android.content.Context
import android.content.SharedPreferences

class Intromanager{
    var pref: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null
    var context: Context? = null


    fun Intromanager(context: Context) {
        this.context = context
        pref = context.getSharedPreferences("first", 0)
        //editor = pref.edit()
    }

    fun setFirst(isFirst: Boolean) {
        editor!!.putBoolean("check", isFirst)
        editor!!.commit()
    }

    fun Check(): Boolean {
        return pref!!.getBoolean("check", true)
    }

}
