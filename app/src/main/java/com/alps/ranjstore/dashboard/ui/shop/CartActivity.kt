package com.alps.ranjstore.dashboard.ui.shop

import android.R
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.alps.ranjstore.databinding.ActivityCartBinding


class CartActivity : AppCompatActivity() {

    private lateinit var binding:ActivityCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val toolbar: Toolbar = findViewById<View>(com.alps.ranjstore.R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        getSupportActionBar()?.setDisplayShowHomeEnabled(true);
        getSupportActionBar()?.setTitle("CartActivity");
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
       // getSupportActionBar()>.setDisplayUseLogoEnabled(true);
    }
    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        val id = menuItem.itemId
        if (id == R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(menuItem)
    }
}