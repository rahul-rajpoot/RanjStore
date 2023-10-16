package com.alps.ranjstore.activities

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alps.ranjstore.R
import com.alps.ranjstore.com.alps.ranjstore.net.ImplApiServices
import com.alps.ranjstore.com.alps.ranjstore.viewmodel.login.LoginViewModel
import com.alps.ranjstore.com.alps.ranjstore.viewmodel.login.LoginViewModelFactory
import com.alps.ranjstore.dashboard.MainActivity
import com.alps.ranjstore.databinding.ActivityLoginBinding
import com.alps.ranjstore.repository.LoginRepository

class LoginActivity : AppCompatActivity() {
    private lateinit var loginBinding: ActivityLoginBinding
    private lateinit var loginViewModel: LoginViewModel
    var passwordVisible: Boolean = false
    var checkBoxVisible: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)

        loginBinding.backbton.setOnClickListener {

            finish()
        }

        loginViewModel =  ViewModelProvider(this, LoginViewModelFactory(LoginRepository(ImplApiServices()))).get(LoginViewModel::class.java)
        loginBinding.sumbit.setOnClickListener { view ->
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)

            val dialog = Dialog(this)
            dialog.setContentView(R.layout.dialog_loading)
            //  dialog.setCancelable(false)
            if(dialog.window !=null){
                dialog!!.window!!.setBackgroundDrawable(ColorDrawable(0))
            }
            dialog.show()

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

        loginViewModel.validate().observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })



    }


        @SuppressLint("LogNotTimber")
        fun login(){
            val username =  loginBinding.username.text.toString().trim()

            val password =  loginBinding.password1.text.toString().trim()

            val checkbox =  loginBinding.enable.text.toString().trim()

            val bolean = checkbox.toBoolean()

            Log.e( "login: ", bolean.toString())
            if(bolean.or(checkBoxVisible))
            //    Toast.makeText(this, "it", Toast.LENGTH_LONG).show()


             loginBinding.password1.setOnTouchListener(object : View.OnTouchListener {
                override fun onTouch(view: View?, event: MotionEvent): Boolean {
                    val Right = 2
                    if (event.getAction() === MotionEvent.ACTION_UP) {
                        if (event.getRawX() >=  loginBinding.password1.getRight() -    loginBinding.password1.getCompoundDrawables()
                                .get(Right).getBounds().width()
                        ) {
                            val selection: Int =  loginBinding.password1.getSelectionEnd()
                            if (passwordVisible) {
                                loginBinding.password1.setCompoundDrawablesRelativeWithIntrinsicBounds(
                                    0,
                                    0,
                                    R.drawable.baseline_visibility_off_24,
                                    0
                                )
                                loginBinding.password1.setTransformationMethod(
                                    PasswordTransformationMethod.getInstance())
                                passwordVisible = false
                            } else {
                                loginBinding.password1.setCompoundDrawablesRelativeWithIntrinsicBounds(
                                    0,
                                    0,
                                    R.drawable.baseline_visibility_24,
                                    0
                                )
                                loginBinding.password1.setTransformationMethod(
                                    HideReturnsTransformationMethod.getInstance())
                                passwordVisible = true
                            }
                            loginBinding.password1.setSelection(selection)
                            return true
                        }
                    }
                    return false
                }
            })

            loginViewModel.loginView(username,password)
        }


      fun  hidepassword(){

      }


    }
