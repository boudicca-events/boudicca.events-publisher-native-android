package com.example.bouddicaclient.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
  primary = Purple200,
  secondary = Teal200
)

private val LightColorScheme = lightColorScheme(
  primary = Purple500,
  secondary = Teal200

  /* Other default colors to override
  background = Color.White,
  surface = Color.White,
  onPrimary = Color.White,
  onSecondary = Color.Black,
  onBackground = Color.Black,
  onSurface = Color.Black,
  */
)

@Composable
fun HiltMVVMComposeMovieTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  content: @Composable() () -> Unit
) {
  val colors = if (darkTheme) {
    DarkColorScheme
  } else {
    LightColorScheme
  }

  MaterialTheme(
    colorScheme = colors,
    shapes = Shapes,
    content = content
  )
}
