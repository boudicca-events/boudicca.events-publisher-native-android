package com.example.bouddicaclient.data.repository

import com.example.bouddicaclient.data.datasource.remote.APIService
import com.example.bouddicaclient.data.model.EventItem
import com.example.bouddicaclient.data.model.Response
import com.example.bouddicaclient.data.model.SearchRequest

import javax.inject.Inject

class EventRepository @Inject constructor(
  private val apiService: APIService
) : EventRepositoryInterface {
  suspend fun getEvents(): List<EventItem> {
    return apiService.getEvents()
  }

  suspend fun queryEntries(query: String, offset: Int, size: Int): Response {
    val searchRequest = SearchRequest(query, offset, size)
    return apiService.queryEntries(searchRequest)
  }
}
