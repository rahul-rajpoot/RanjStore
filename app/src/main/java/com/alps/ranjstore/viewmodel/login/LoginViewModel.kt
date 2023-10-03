package com.alps.ranjstore.com.alps.ranjstore.viewmodel.login

import android.text.TextUtils
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alps.ranjstore.repository.LoginRepository


class LoginViewModel constructor(private val loginRepository: LoginRepository): ViewModel() {

    private var countryId = MutableLiveData<String>()
    private var validation = MutableLiveData<String>()

     fun validate(): LiveData<String> {

        return validation
    }
    private var phoneId = MutableLiveData<String>()





    fun loginView(username: String, password: String) {

        Log.e( "loginView: ", username)
        if(TextUtils.isEmpty(username)){
            validation.postValue("Username Required Parameter")
            return


        }

        if(TextUtils.isEmpty(password)){
            validation.postValue("Password Required Parameter")
            return


        }

        Log.e( "loginView: ", password)

    }
}