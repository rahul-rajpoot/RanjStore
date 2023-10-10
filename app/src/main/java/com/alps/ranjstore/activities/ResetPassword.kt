package com.alps.ranjstore.activities

import android.app.Dialog
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alps.ranjstore.R
import com.alps.ranjstore.com.alps.ranjstore.net.ImplApiServices
import com.alps.ranjstore.com.alps.ranjstore.repository.ResetRepository
import com.alps.ranjstore.com.alps.ranjstore.viewmodel.resetpassword.ResetViewModel
import com.alps.ranjstore.com.alps.ranjstore.viewmodel.resetpassword.ResetViewModelfactory
import com.alps.ranjstore.databinding.ActivityResetPasswordBinding


class ResetPassword : AppCompatActivity() {



    private lateinit var  resetpasswordBinding:ActivityResetPasswordBinding

    private lateinit var resetViewModel: ResetViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        resetpasswordBinding = ActivityResetPasswordBinding.inflate(layoutInflater)
        setContentView(resetpasswordBinding.root)
       resetViewModel = ViewModelProvider(this,ResetViewModelfactory(ResetRepository(ImplApiServices()))).get(ResetViewModel::class.java)

        resetpasswordBinding.backbton.setOnClickListener {

            finish()
        }

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

            val dialog = Dialog(this)
            dialog.setContentView(R.layout.dialog_loading)
            //  dialog.setCancelable(false)
            if(dialog.window !=null){
                dialog!!.window!!.setBackgroundDrawable(ColorDrawable(0))
            }
            dialog.show()
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