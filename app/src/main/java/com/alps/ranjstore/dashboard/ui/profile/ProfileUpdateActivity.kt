package com.alps.ranjstore.dashboard.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.alps.ranjstore.R

import com.alps.ranjstore.databinding.ActivityProfileUpdateBinding

class ProfileUpdateActivity : AppCompatActivity() {

    private lateinit var binding:ActivityProfileUpdateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityProfileUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val toolbar: Toolbar = findViewById<View>(com.alps.ranjstore.R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        getSupportActionBar()?.setDisplayShowHomeEnabled(true);
        getSupportActionBar()?.setTitle("ProfileUpdateActivity");
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        /*getSupportActionBar()?.setLogo(R.drawable.baseline_arrow_back_ios_new_24);*/
         getSupportActionBar()?.setDisplayUseLogoEnabled(true);
       /* binding.backbton.setOnClickListener {

            finish()
        }*/




    }
    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        val id = menuItem.itemId
        if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(menuItem)
    }
}