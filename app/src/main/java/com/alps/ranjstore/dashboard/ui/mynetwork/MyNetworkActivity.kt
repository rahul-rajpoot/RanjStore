package com.alps.ranjstore.dashboard.ui.mynetwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alps.ranjstore.databinding.ActivityMyNetworkBinding

class MyNetworkActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMyNetworkBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMyNetworkBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}