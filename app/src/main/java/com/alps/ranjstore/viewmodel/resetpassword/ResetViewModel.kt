package com.alps.ranjstore.com.alps.ranjstore.viewmodel.resetpassword

import android.util.Log
import androidx.lifecycle.ViewModel
import com.alps.ranjstore.com.alps.ranjstore.repository.ResetRepository
import kotlin.math.log

class ResetViewModel constructor(private val resetRepository: ResetRepository): ViewModel()  {

    fun  ResetView(username: String) {
        Log.e("ResetView: ", username)

    }
}