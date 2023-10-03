package com.alps.ranjstore.com.alps.ranjstore.viewmodel.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alps.ranjstore.repository.LoginRepository

class LoginViewModelFactory constructor(private val loginRepository: LoginRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            LoginViewModel(this.loginRepository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}