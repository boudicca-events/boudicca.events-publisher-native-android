package com.example.bouddicaclient.ui.screens.mainscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bouddicaclient.R

import com.example.bouddicaclient.navigation.Screen
import com.example.bouddicaclient.ui.screens.bookmarkscreen.BookmarkScreen
import com.example.bouddicaclient.ui.screens.homescreen.HomeScreen
import com.google.accompanist.systemuicontroller.rememberSystemUiController

import androidx.compose.foundation.Image
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

import timber.log.Timber

val screens = listOf(
  Screen.Home,
  Screen.Bookmark
)

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
  val navController = rememberNavController()
  val TAG = "main screen"

  val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

  val systemUiController = rememberSystemUiController()
  val useDarkIcons = !isSystemInDarkTheme()

  // Move the system bar color setting to the composable
  systemUiController.setSystemBarsColor(
    color = MaterialTheme.colorScheme.primaryContainer,
    darkIcons = useDarkIcons
  )

  systemUiController.isNavigationBarVisible = false

  LaunchedEffect(key1 = true) {
    Timber.tag(TAG).d("mainscreen:: This is a debug message")
  }

  Scaffold(
    contentColor = Color.White,
    topBar = {
      LargeTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
          containerColor = MaterialTheme.colorScheme.primaryContainer,
          titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        navigationIcon = {
          IconToggleButton(
            checked = false,
            onCheckedChange = { /* Handle navigation icon click */ }
          ) {
            Image(
              painter = painterResource(R.drawable.boudicca_logo),
              contentDescription = "Boudicca Logo",
              modifier = Modifier
                .fillMaxSize()
                .scale(0.75f)
            )
          }
        },
        title = {
          Text(
            "BOUDICCA.EVENTS",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.headlineLarge
          )
        },
        actions = {
          IconButton(onClick = { /* do something */ }) {
            Icon(
              imageVector = Icons.Filled.FilterList,
              contentDescription = "Localized description"
            )
          }
        },
        scrollBehavior = scrollBehavior
      )
    },
    bottomBar = {
      NavigationBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
      ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        screens.forEach { screen: Screen ->
          NavigationBarItem(
            selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
            icon = { Icon(imageVector = screen.icon, contentDescription = stringResource(screen.resourceId)) },
            label = { Text(stringResource(screen.resourceId)) },
            colors = NavigationBarItemDefaults.colors(
              selectedIconColor = Color.White,
              selectedTextColor = Color.Black,
              unselectedIconColor = Color.LightGray,
              unselectedTextColor = Color.LightGray,
              indicatorColor = Color.Gray
            ),
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
            },
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
