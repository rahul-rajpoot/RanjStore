package com.alps.ranjstore.com.alps.ranjstore.viewmodel.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alps.ranjstore.com.alps.ranjstore.repository.RegisterRepository

class RegisterViewModelFactory constructor(private val registerRepository: RegisterRepository) :ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            RegisterViewModel(this.registerRepository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}