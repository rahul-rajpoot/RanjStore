package com.alps.ranjstore.com.alps.ranjstore.viewmodel.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alps.ranjstore.repository.LoginRepository

class LoginViewModel constructor(private val loginRepository: LoginRepository): ViewModel() {

    private var countryId = MutableLiveData<String>()
    private var phoneId = MutableLiveData<String>()
   // private var login = MutableLiveData<OtpResponse>()




    fun loginView(username: String, password: String) {

        Log.e( "loginView: ", username)
        Log.e( "loginView: ", password)

    }
}