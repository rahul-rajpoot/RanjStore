package com.alps.ranjstore.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.alps.ranjstore.com.alps.ranjstore.net.ImplApiServices
import com.alps.ranjstore.com.alps.ranjstore.repository.RegisterRepository
import com.alps.ranjstore.com.alps.ranjstore.viewmodel.register.RegisterViewModel
import com.alps.ranjstore.com.alps.ranjstore.viewmodel.register.RegisterViewModelFactory
import com.alps.ranjstore.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var signUpBinding: ActivitySignUpBinding
    private lateinit var registerviewModel: RegisterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signUpBinding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(signUpBinding.root)
        registerviewModel = ViewModelProvider(
            this, RegisterViewModelFactory(
                RegisterRepository(
                    ImplApiServices()
                )
            )
        ).get(RegisterViewModel::class.java)

/*
        signUpBinding.submit.setOnClickListener {

            registerView()
        }*/

        signUpBinding.backbton.setOnClickListener {

            finish()
        }
    }
    private fun registerView() {
    }
}