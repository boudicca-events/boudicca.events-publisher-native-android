package com.example.bouddicaclient.data.model

import com.google.gson.annotations.SerializedName

data class SearchRequest(
  @SerializedName("query") val query: String,
  @SerializedName("offset") val offset: Int,
  @SerializedName("size") val size: Int
)
