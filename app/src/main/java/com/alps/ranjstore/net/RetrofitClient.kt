package com.alps.ranjstore.net

import com.alps.ranjstore.utils.URLs
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        fun getInstance(): ApiServices {
            val retrofit = Retrofit.Builder()
                .baseUrl(URLs.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())

                .build()
            return retrofit.create(ApiServices::class.java)

        }
    }
}