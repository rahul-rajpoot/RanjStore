package com.alps.ranjstore.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alps.ranjstore.R
import com.alps.ranjstore.databinding.ActivityPromostionalBinding

class PromostionalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPromostionalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityPromostionalBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}