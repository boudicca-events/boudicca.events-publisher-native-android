package com.example.bouddicaclient.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.ViewList
import androidx.compose.ui.graphics.vector.ImageVector

import com.example.bouddicaclient.R

sealed class Screen(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {
  data object Home : Screen(route = "events", resourceId = R.string.screen_home, icon = Icons.Filled.ViewList)
  data object Bookmark : Screen(route = "bookmark", resourceId = R.string.screen_bookmark, icon = Icons.Filled.Bookmark)
}
