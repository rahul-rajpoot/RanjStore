package com.alps.ranjstore.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar

import com.alps.ranjstore.databinding.ActivityWhishListBinding

class WhishListActivity : AppCompatActivity() {
    private lateinit var binding:ActivityWhishListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityWhishListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = findViewById<View>(com.alps.ranjstore.R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        getSupportActionBar()?.setDisplayShowHomeEnabled(true);
        getSupportActionBar()?.setTitle("WhishList");


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
