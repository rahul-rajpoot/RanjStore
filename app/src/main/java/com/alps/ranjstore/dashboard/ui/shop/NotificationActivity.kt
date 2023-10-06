package com.alps.ranjstore.dashboard.ui.shop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.alps.ranjstore.R
import com.alps.ranjstore.databinding.ActivityNotificationBinding

class NotificationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = findViewById<View>(com.alps.ranjstore.R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        getSupportActionBar()?.setDisplayShowHomeEnabled(true);
        getSupportActionBar()?.setTitle("Notification");


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