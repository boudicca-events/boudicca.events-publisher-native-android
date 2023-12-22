package com.example.bouddicaclient.ui.screens.mainscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import com.example.bouddicaclient.ui.components.EventList

import timber.log.Timber

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
  val mainViewModel = hiltViewModel<MainViewModel>()
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
      EventList(events = events ?: emptyList())
    }
  }
}
