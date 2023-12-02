package com.example.bouddicaclient.ui.screens.mainscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
//import com.example.bouddicaclient.R
//import com.example.bouddicaclient.data.model.Genres
//import com.example.bouddicaclient.data.model.moviedetail.Genre
import com.example.bouddicaclient.navigation.*
//import com.example.bouddicaclient.ui.component.CircularIndeterminateProgressBar
//import com.example.bouddicaclient.ui.component.appbar.AppBarWithArrow
//import com.example.bouddicaclient.ui.component.SearchUI
//import com.example.bouddicaclient.ui.component.appbar.SearchBar
//import com.example.bouddicaclient.ui.component.appbar.HomeAppBar
//import com.example.bouddicaclient.ui.screens.drawer.DrawerUI
import com.example.bouddicaclient.ui.theme.FloatingActionBackground
import com.example.bouddicaclient.navigation.Screen
//import com.example.bouddicaclient.utils.AppConstant
//import com.example.bouddicaclient.utils.network.DataState
//import com.example.bouddicaclient.utils.networkconnection.ConnectionState
//import com.example.bouddicaclient.utils.networkconnection.connectivityState
//import com.example.bouddicaclient.utils.pagingLoadingState
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview
@Composable
fun MainScreen() {
  val mainViewModel = hiltViewModel<MainViewModel>()
  val navController = rememberNavController()
  val scaffoldState = rememberScaffoldState()
  val scope = rememberCoroutineScope()
  val isAppBarVisible = remember { mutableStateOf(true) }
  val searchProgressBar = remember { mutableStateOf(false) }
  val genreName = remember { mutableStateOf("") }
//  val genreList = remember { mutableStateOf(arrayListOf<Genre>()) }
  // internet connection
//  val connection by connectivityState()
//  val isConnected = connection === ConnectionState.Available

  // genre api call for first time
  LaunchedEffect(key1 = 0) {
//    mainViewModel.genreList()
  }

//  if (mainViewModel.genres.value is DataState.Success<Genres>) {
//    genreList.value =
//      (mainViewModel.genres.value as DataState.Success<Genres>).data.genres as ArrayList
//    // All first value as all
//    if (genreList.value.first().name != AppConstant.DEFAULT_GENRE_ITEM)
//      genreList.value.add(0, Genre(null, AppConstant.DEFAULT_GENRE_ITEM))
//  }

  Scaffold(scaffoldState = scaffoldState, content = {
    Text("my app")
  })
}
