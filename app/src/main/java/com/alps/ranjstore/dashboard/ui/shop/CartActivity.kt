package com.alps.ranjstore.dashboard.ui.shop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alps.ranjstore.R
import com.alps.ranjstore.databinding.ActivityCartBinding

class CartActivity : AppCompatActivity() {

    private lateinit var binding:ActivityCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}