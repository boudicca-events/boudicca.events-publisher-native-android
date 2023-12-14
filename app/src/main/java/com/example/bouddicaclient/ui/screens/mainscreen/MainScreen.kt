package com.example.bouddicaclient.ui.screens.mainscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import com.example.bouddicaclient.data.model.EventItem
import com.example.bouddicaclient.ui.components.EventList
import timber.log.Timber

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview
@Composable
fun MainScreen() {
  val mainViewModel = hiltViewModel<MainViewModel>()

  // Observe the LiveData using Hilt's observeAsState
  val events by mainViewModel.events.observeAsState()

  val TAG = "main screen"

  // Trigger the API call
  LaunchedEffect(key1 = true) {
    Timber.tag(TAG).d("This is a debug message")
    mainViewModel.loadEvents()
  }

  Surface(
    contentColor = Color.White
  ) {
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .background(
          color = Color.Gray
        ),
    ) {
//      val events : List<EventItem> = listOf(
//        EventItem(name = "my event", startDate = "today"),
//        EventItem(name = "my event", startDate = "tomorrow"),
//        EventItem(name = "my event", startDate = "tomorrow"),
//        EventItem(name = "my event", startDate = "tomorrow"),
//        EventItem(name = "my event", startDate = "tomorrow"),
//      )
      EventList(events = events ?: emptyList())
    }
  }
}
