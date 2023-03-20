package com.sample.app.mycbseguide.network

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    @GET("category/all")
    suspend fun getCategoryAll():Response<ResponseBody>
}