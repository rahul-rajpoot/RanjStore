package com.alps.ranjstore.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alps.ranjstore.R
import com.alps.ranjstore.databinding.ActivityCustomerBinding

class CustomerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCustomerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomerBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}