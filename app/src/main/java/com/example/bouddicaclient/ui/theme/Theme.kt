package com.example.bouddicaclient.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
  primary = Color.Black,
  secondary = Teal200,
  primaryContainer = Color.White,
  background = Blue
)

private val LightColorScheme = lightColorScheme(
  primary = Color.Black,
  secondary = Teal200,
  primaryContainer = Color.White,
  background = Blue

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
    content = content,
    typography = Typography
  )
}
