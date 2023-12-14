//package com.example.bouddicaclient.navigation
//
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Modifier
//import androidx.navigation.NavController
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.currentBackStackEntryAsState
//import com.example.bouddicaclient.navigation.Screen
//
//@Composable
//fun Navigation(
//  navController: NavHostController, modifier: Modifier,
//) {
//  NavHost(navController, startDestination = Screen.Home.route, modifier) {
//    composable(Screen.Home.route) {
////      NowPlaying(
////        navController = navController,
////      )
//    }
////    composable(Screen.Popular.route) {
////      Popular(
////        navController = navController,
////        genres
////      )
////    }
////    composable(Screen.TopRated.route) {
////      TopRated(
////        navController = navController,
////        genres
////      )
////    }
//  }
//}
//
//@Composable
//fun currentRoute(navController: NavController): String? {
//  val navBackStackEntry by navController.currentBackStackEntryAsState()
//  return navBackStackEntry?.destination?.route?.substringBeforeLast("/")
//}