package com.alps.ranjstore.com.alps.ranjstore.viewmodel.resetpassword

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alps.ranjstore.com.alps.ranjstore.repository.ResetRepository
import com.alps.ranjstore.com.alps.ranjstore.viewmodel.register.RegisterViewModel

class ResetViewModelfactory  constructor(private val resetRepository: ResetRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(ResetViewModel::class.java)) {
            ResetViewModel(this.resetRepository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}