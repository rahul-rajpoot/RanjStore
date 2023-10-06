package com.alps.ranjstore.dashboard.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alps.ranjstore.R
import com.alps.ranjstore.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding:ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityProfileBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_profile)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
    }
}