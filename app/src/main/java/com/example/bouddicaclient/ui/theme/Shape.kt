package com.example.bouddicaclient.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
  small = RoundedCornerShape(4.dp),
  medium = RoundedCornerShape(4.dp),
  large = RoundedCornerShape(0.dp)
)

@SuppressLint("ModifierFactoryUnreferencedReceiver")
fun Modifier.cornerRadius(radius: Int) =
  graphicsLayer(shape = RoundedCornerShape(radius.dp), clip = true)