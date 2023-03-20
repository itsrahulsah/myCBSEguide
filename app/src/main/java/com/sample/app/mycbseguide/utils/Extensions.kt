package com.sample.app.mycbseguide.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.sample.app.mycbseguide.R



    fun ImageView.load(img:String?,placeholder:Int = R.drawable.books){
        if(img != null) {
            Glide.with(context)
                .load(img)
                .error(placeholder)
                .placeholder(placeholder)
                .into(this)
        }else{
            this.setImageResource(placeholder)
        }
    }
