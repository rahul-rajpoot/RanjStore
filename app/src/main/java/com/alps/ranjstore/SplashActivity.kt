package com.alps.ranjstore

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.alps.ranjstore.com.alps.ranjstore.adapter.IntroSliderAdapter
import com.alps.ranjstore.com.alps.ranjstore.model.splash.IntroSlide
import com.alps.ranjstore.activities.LoginActivity
import com.alps.ranjstore.dashboard.MainActivity
import com.alps.ranjstore.databinding.ActivitySplashBinding

@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {
    var handler : Handler? =null
    private val introSliderAdapter = IntroSliderAdapter(
        listOf(
            IntroSlide(
                R.drawable.splash_1
            ),
            IntroSlide(
                R.drawable.splash_2
            ),
            IntroSlide(

                R.drawable.splash_3
            )
        )
    )

    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ) {
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.introSliderViewPager.adapter = introSliderAdapter

        setupIndicators()
        setCurrentIndicators(0)

        binding. introSliderViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicators(position)
                handler!!.removeCallbacks(runnable)
                handler!!.postDelayed(runnable , 2000)
            }
        })

        binding.btnNext.setOnClickListener {
            if (binding.introSliderViewPager.currentItem + 1 < introSliderAdapter.itemCount) {
                binding.introSliderViewPager.currentItem +=1
            }else{
                Intent(applicationContext, MainActivity:: class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }

        binding. textSkipIntro.setOnClickListener {

         Intent(applicationContext, MainActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }



    }

    //*********Runnable Autu ImageSilder************************/
    override fun onPause() {
        super.onPause()

        handler!!.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()

        handler!!.postDelayed(runnable , 2000)
    }

    private val runnable = Runnable {
        binding.introSliderViewPager.currentItem = binding.introSliderViewPager.currentItem + 1
    }
    private fun setupIndicators() {
        val indicators = arrayOfNulls<ImageView>(introSliderAdapter.itemCount)
        handler = Handler(Looper.myLooper()!!)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

        layoutParams.setMargins(8, 0, 8, 0)
        for (i in indicators.indices) {
            indicators[i] = ImageView(applicationContext)
            indicators[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
                this?.layoutParams = layoutParams
            }
           binding. indicatorsContainer.addView(indicators[i])

        }
    }

    private fun setCurrentIndicators(index : Int) {
        val childCount = binding.indicatorsContainer.childCount
        for (i in 0 until childCount) {
            val imageView =
                binding.indicatorsContainer[i] as ImageView
            if (i == index) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
            }
        }
    }






}


   
