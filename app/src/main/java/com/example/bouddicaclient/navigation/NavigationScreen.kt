package com.example.bouddicaclient.navigation

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Timeline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bouddicaclient.R

sealed class Screen(
  val route: String,
  @StringRes val title: Int = 0,
  val navIcon: (@Composable () -> Unit) = {
    Icon(
      Icons.Filled.Home, contentDescription = "home"
    )
  },
) {
  object HomeNav : Screen("home_screen", title = 0, navIcon = {
    Icon(
      Icons.Filled.Home,
      contentDescription = "search",
      modifier = Modifier
        .padding(end = 16.dp)
        .offset(x = 10.dp)
    )
  })
}