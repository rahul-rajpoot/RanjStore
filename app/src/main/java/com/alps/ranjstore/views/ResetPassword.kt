package com.alps.ranjstore.com.alps.ranjstore.views

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alps.ranjstore.com.alps.ranjstore.net.ImplApiServices
import com.alps.ranjstore.com.alps.ranjstore.repository.ResetRepository
import com.alps.ranjstore.com.alps.ranjstore.viewmodel.resetpassword.ResetViewModel
import com.alps.ranjstore.com.alps.ranjstore.viewmodel.resetpassword.ResetViewModelfactory
import com.alps.ranjstore.databinding.ActivityResetPasswordBinding
import com.alps.ranjstore.views.SignUpActivity


class ResetPassword : AppCompatActivity() {



    private lateinit var  resetpasswordBinding:ActivityResetPasswordBinding

    private lateinit var resetViewModel: ResetViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        resetpasswordBinding = ActivityResetPasswordBinding.inflate(layoutInflater)
        setContentView(resetpasswordBinding.root)
       resetViewModel = ViewModelProvider(this,ResetViewModelfactory(ResetRepository(ImplApiServices()))).get(ResetViewModel::class.java)



        resetpasswordBinding.login.setOnClickListener {
            val i = Intent(this@ResetPassword, LoginActivity::class.java)
            startActivity(i)
            finish()
        }


        resetpasswordBinding.createAccount.setOnClickListener(View.OnClickListener {
            val i = Intent(this@ResetPassword, SignUpActivity::class.java)
            startActivity(i)
            finish()
        })

        resetpasswordBinding.restbt.setOnClickListener {
            resetpassword()
        }

        resetViewModel.validate().observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })

    }

    private fun resetpassword() {
        val username =  resetpasswordBinding.usernameReset.text.toString().trim()


        Log.e("resetpassword: ",username )
        resetViewModel.ResetView(username)


    }
}