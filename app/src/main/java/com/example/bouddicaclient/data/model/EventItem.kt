package com.example.bouddicaclient.data.model

import com.google.gson.annotations.SerializedName

data class EventItem(
  @SerializedName("name")
  val name: String,
  @SerializedName("startDate")
  val startDate: String,
  @SerializedName("collectorName")
  val collectorName: String? = null,
  @SerializedName("sources")
  val sources: String? = null,
  @SerializedName("registration")
  val registration: String? = null,
  @SerializedName("description")
  val description: String? = null,
  @SerializedName("type")
  val type: String? = null,
  @SerializedName("url")
  val url: String? = null,
  @SerializedName("tags")
  val tags: Tags? = null
)
