package com.alps.ranjstore.dashboard.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.alps.ranjstore.R
import com.alps.ranjstore.databinding.ActivityProfileBinding
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
        //getSupportActionBar()?.setTitle("CartActivity");
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        // getSupportActionBar()>.setDisplayUseLogoEnabled(true);

    }
    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        val id = menuItem.itemId
        if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(menuItem)
    }
}