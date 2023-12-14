package com.example.bouddicaclient.data.datasource.remote

import com.example.bouddicaclient.data.model.EventItem
import com.example.bouddicaclient.data.model.Response
import com.example.bouddicaclient.data.model.SearchRequest
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Body

interface APIService {
  @GET("events")
  suspend fun getEvents(): List<EventItem>

  @POST("queryEntries")
  suspend fun searchEvents(@Body request: SearchRequest): Response
}
