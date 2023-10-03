package com.alps.ranjstore.com.alps.ranjstore.views

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.alps.ranjstore.com.alps.ranjstore.net.ImplApiServices
import com.alps.ranjstore.com.alps.ranjstore.viewmodel.login.LoginViewModel
import com.alps.ranjstore.com.alps.ranjstore.viewmodel.login.LoginViewModelFactory
import com.alps.ranjstore.dashboard.MainActivity
import com.alps.ranjstore.databinding.ActivityLoginBinding
import com.alps.ranjstore.repository.LoginRepository
import com.alps.ranjstore.views.SignUpActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var loginBinding: ActivityLoginBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)

        loginViewModel =  ViewModelProvider(this, LoginViewModelFactory(LoginRepository(ImplApiServices()))).get(LoginViewModel::class.java)
        loginBinding.sumbit.setOnClickListener { view ->
           val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
            login()
        }


        loginBinding.password.setOnClickListener { view ->
            val intent = Intent(this@LoginActivity, ResetPassword::class.java)
             startActivity(intent)

        }


        loginBinding.register.setOnClickListener { view ->
            val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
            startActivity(intent)

        }
    }


        @SuppressLint("LogNotTimber")
        fun login(){
            val username =  loginBinding.username.text.toString().trim()

            val password =  loginBinding.password1.text.toString().trim()

           /* tv_pwd_confirm.setOnTouchListener(object : View.OnTouchListener {
                override fun onTouch(view: View?, event: MotionEvent): Boolean {
                    val Right = 2
                    if (event.getAction() === MotionEvent.ACTION_UP) {
                        if (event.getRawX() >= tv_pwd_confirm.getRight() - tv_pwd_confirm.getCompoundDrawables()
                                .get(Right).getBounds().width()
                        ) {
                            val selection: Int = tv_pwd_confirm.getSelectionEnd()
                            if (passwordVisible) {
                                tv_pwd_confirm.setCompoundDrawablesRelativeWithIntrinsicBounds(
                                    0,
                                    0,
                                    R.drawable.ic_baseline_visibility_off_24,
                                    0
                                )
                                tv_pwd_confirm.setTransformationMethod(PasswordTransformationMethod.getInstance())
                                passwordVisible = false
                            } else {
                                tv_pwd_confirm.setCompoundDrawablesRelativeWithIntrinsicBounds(
                                    0,
                                    0,
                                    R.drawable.ic_baseline_visibility_24,
                                    0
                                )
                                tv_pwd_confirm.setTransformationMethod(HideReturnsTransformationMethod.getInstance())
                                passwordVisible = true
                            }
                            tv_pwd_confirm.setSelection(selection)
                            return true
                        }
                    }
                    return false
                }
            })*/

            loginViewModel.loginView(username,password)
        }


    }
