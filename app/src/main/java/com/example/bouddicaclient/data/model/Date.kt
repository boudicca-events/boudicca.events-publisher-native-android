package com.example.bouddicaclient.data.model

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

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

  val formattedDate: String
    get() {
      val formattedDate = dateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.GERMAN))
      val formattedTime = dateTime.format(DateTimeFormatter.ofPattern("HH:mm 'Uhr'", Locale.GERMAN))
      return "$formattedDate um $formattedTime"
    }
}
