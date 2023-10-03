package com.alps.ranjstore.com.alps.ranjstore.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.alps.ranjstore.R
import com.alps.ranjstore.com.alps.ranjstore.model.splash.IntroSlide

class IntroSliderAdapter(private val introSlide: List<IntroSlide>)
    : RecyclerView.Adapter<IntroSliderAdapter.IntroSlideViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroSlideViewHolder {
        return IntroSlideViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.slide_item_container,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return introSlide.size
    }

    override fun onBindViewHolder(holder: IntroSlideViewHolder, position: Int) {
        holder.bind(introSlide[position])
    }




    inner class IntroSlideViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        /* private val textTitle = view.findViewById<TextView>(R.id.textTitle)
         private val textDescription = view.findViewById<TextView>(R.id.textDescription)*/
        private val imageIcon = view.findViewById<ImageView>(R.id.imageSlideIcon)


        fun bind(introSlide: IntroSlide) {
            /*  textTitle.text = introSlide.title
              textDescription.text = introSlide.descriptor*/
            imageIcon.setImageResource(introSlide.icon)
        }


    }

}