package com.example.bouddicaclient.data.datasource.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun createAPIService(): APIService {
  val retrofit = Retrofit.Builder()
    .baseUrl(APIURL.BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

  return retrofit.create(APIService::class.java)
}
