package com.example.bouddicaclient.ui.screens.mainscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

import com.example.bouddicaclient.navigation.Screen
import com.example.bouddicaclient.ui.screens.bookmarkscreen.BookmarkScreen
import com.example.bouddicaclient.ui.screens.homescreen.HomeScreen

import timber.log.Timber

val screens = listOf(
  Screen.Home,
  Screen.Bookmark
)

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
  val navController = rememberNavController()
  val TAG = "main screen"

  LaunchedEffect(key1 = true) {
    Timber.tag(TAG).d("mainscreen:: This is a debug message")
  }

  Scaffold(
    contentColor = Color.White,
    bottomBar = {
      NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        screens.forEach { screen: Screen ->
          NavigationBarItem(
            selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
            label = { Text(stringResource(screen.resourceId)) },
            icon = { Icon(imageVector = screen.icon, contentDescription = stringResource(screen.resourceId)) },
            onClick = {
              navController.navigate(screen.route) {
                // Pop up to the start destination of the graph to
                // avoid building up a large stack of destinations
                // on the back stack as users select items
                popUpTo(navController.graph.findStartDestination().id) {
                  saveState = true
                }
                // Avoid multiple copies of the same destination when
                // reselecting the same item
                launchSingleTop = true
                // Restore state when reselecting a previously selected item
                restoreState = true
              }
            }
          )
        }
      }
    }
  ) {innerPadding ->
    NavHost(navController, startDestination = Screen.Home.route, Modifier.padding(innerPadding)) {
      composable(Screen.Home.route) { HomeScreen(navController) }
      composable(Screen.Bookmark.route) { BookmarkScreen(navController) }
    }
  }
}
