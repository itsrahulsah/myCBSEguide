package com.sample.app.mycbseguide.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://api.mycbseguide.com/v1/"

    private val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

   fun getApiService():APIService{
       return retrofit.create(APIService::class.java)
   }

    }