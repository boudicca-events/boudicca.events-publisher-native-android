package com.example.bouddicaclient.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import com.example.bouddicaclient.data.model.EventItem

@Composable
fun EventList(
  events: List<EventItem>,
) {
  Column(
    modifier = Modifier.verticalScroll(rememberScrollState())
  ) {
    events.forEach {
      EventCard(eventTitle = it.name, eventLocation = it.location ?: "no location", eventDateTime = it.startDate, imageUrl = it.pictureUrl)
    }
  }
}