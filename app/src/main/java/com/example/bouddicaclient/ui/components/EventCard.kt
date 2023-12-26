package com.example.bouddicaclient.ui.components

import com.example.bouddicaclient.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import androidx.compose.ui.res.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun EventCard(
  eventTitle: String = "Sample Event Title",
  eventLocation: String = "Sample Event Location",
  eventDateTime: String = "Sample Event Data and Time",
  imageUrl: String? = null // Pass the image URL as a parameter
) {
  Card(
    onClick = { println("todo") },
    colors = CardDefaults.cardColors(
      containerColor = MaterialTheme.colorScheme.background,
      contentColor = Color.Black,
      disabledContainerColor = Color.Gray,
      disabledContentColor = Color.Black
    ),
    modifier = Modifier.fillMaxWidth().padding(16.dp),
  ) {
    Column(
      modifier = Modifier
        .padding(24.dp)
        .fillMaxWidth()
    ) {
      val painter = if (!imageUrl.isNullOrBlank()) {
        rememberAsyncImagePainter(imageUrl)
      } else {
        painterResource(id = R.drawable.event_thumbnail) // Use your sample image resource ID
      }

      Image(
        painter = painter,
        contentDescription = "Translated description of what the image contains",
        contentScale = ContentScale.Inside,
        modifier = Modifier.size(100.dp),
      )
      Text(text = eventTitle)
      Text(text = eventLocation)
      Text(text = eventDateTime)
    }
  }
}
