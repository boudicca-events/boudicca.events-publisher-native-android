package com.example.bouddicaclient.navigation

//import com.piashcse.hilt_mvvm_compose_movie.data.model.Genres
//import com.piashcse.hilt_mvvm_compose_movie.ui.screens.genre.GenreScreen
//import com.piashcse.hilt_mvvm_compose_movie.ui.screens.artistdetail.ArtistDetail
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.bouddicaclient.navigation.Screen

//import com.piashcse.hilt_mvvm_compose_movie.ui.screens.moviedetail.MovieDetail
//import com.piashcse.hilt_mvvm_compose_movie.ui.screens.bottomnavigation.popular.Popular
//import com.piashcse.hilt_mvvm_compose_movie.ui.screens.bottomnavigation.toprated.TopRated
//import com.piashcse.hilt_mvvm_compose_movie.ui.screens.bottomnavigation.upcoming.Upcoming
//import com.piashcse.hilt_mvvm_compose_movie.utils.network.DataState

@Composable
fun Navigation(
  navController: NavHostController, modifier: Modifier,
) {
  NavHost(navController, startDestination = Screen.Home.route, modifier) {
    composable(Screen.Home.route) {
//      NowPlaying(
//        navController = navController,
//      )
    }
//    composable(Screen.Popular.route) {
//      Popular(
//        navController = navController,
//        genres
//      )
//    }
//    composable(Screen.TopRated.route) {
//      TopRated(
//        navController = navController,
//        genres
//      )
//    }
  }
}

@Composable
fun currentRoute(navController: NavController): String? {
  val navBackStackEntry by navController.currentBackStackEntryAsState()
  return navBackStackEntry?.destination?.route?.substringBeforeLast("/")
}