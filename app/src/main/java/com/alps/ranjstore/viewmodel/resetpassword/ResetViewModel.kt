package com.alps.ranjstore.com.alps.ranjstore.viewmodel.resetpassword

import android.text.TextUtils
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alps.ranjstore.com.alps.ranjstore.repository.ResetRepository

class ResetViewModel constructor(private val resetRepository: ResetRepository): ViewModel()  {

    private var validation = MutableLiveData<String>()

    fun validate(): LiveData<String> {

        return validation
    }

    fun  ResetView(username: String) {

        if(TextUtils.isEmpty(username)){
            validation.postValue("Username Required Parameter")
            return


        }
        Log.e("ResetView: ", username)

    }
}