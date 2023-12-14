package com.example.bouddicaclient.data.model

import com.google.gson.annotations.SerializedName

data class Response(
  @SerializedName("result")
  val result: List<EventItem>,
  @SerializedName("totalResults")
  val totalResults: Int
)