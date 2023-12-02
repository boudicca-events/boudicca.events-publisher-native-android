package com.example.bouddicaclient.data.model

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Date(val iso8601DateString: String) {
  private val formatter = DateTimeFormatter.ISO_DATE_TIME
  private val dateTime = LocalDateTime.parse(iso8601DateString, formatter)

  val year: Int
    get() = dateTime.year

  val month: Int
    get() = dateTime.monthValue

  val day: Int
    get() = dateTime.dayOfMonth

  val hour: Int
    get() = dateTime.hour
}
