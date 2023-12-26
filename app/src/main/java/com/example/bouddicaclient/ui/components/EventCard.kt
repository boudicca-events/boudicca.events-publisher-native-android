package com.example.bouddicaclient.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.bouddicaclient.R
import com.example.bouddicaclient.data.model.Date

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
    colors = CardDefaults.cardColors(
      containerColor = Color.White,
      contentColor = Color.Black,
      disabledContainerColor = Color.Gray,
      disabledContentColor = Color.Black,
    ),
    onClick = { println("todo") },
    modifier = Modifier.fillMaxWidth().padding(16.dp),
    shape = RectangleShape
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth(),
    ) {
      EventImage(imageUrl)
      Spacer(modifier = Modifier.height(16.dp))
      Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text(text = eventTitle, style = MaterialTheme.typography.titleMedium)
      }
      Spacer(modifier = Modifier.height(8.dp))
      Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
      ) {
        EventIcon(Icons.Default.Schedule, "Date & Time")
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = Date(eventDateTime).formattedDate)
      }
      Spacer(modifier = Modifier.height(8.dp))
      Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
      ) {
        EventIcon(Icons.Outlined.LocationOn, "Location")
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = eventLocation)
      }
    }
  }
}

@Composable
fun EventIcon(icon: ImageVector, contentDescription: String) {
  Icon(
    imageVector = icon,
    contentDescription = contentDescription,
    tint = MaterialTheme.colorScheme.primary
  )
}

@Composable
fun EventImage(
  imageUrl: String? = null
) {
  val painter = if (!imageUrl.isNullOrBlank()) {
    rememberAsyncImagePainter(imageUrl)
  } else {
    painterResource(id = R.drawable.event_thumbnail)
  }

  Card(
    colors = CardDefaults.cardColors(
      containerColor = MaterialTheme.colorScheme.background,
      contentColor = Color.Black,
      disabledContainerColor = Color.Gray,
      disabledContentColor = Color.Black
    )
  ) {
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .height(200.dp),
      contentAlignment = Alignment.Center
    ) {
      Image(
        painter = painter,
        contentDescription = "Translated description of what the image contains",
        contentScale = ContentScale.Inside,
        modifier = Modifier
          .fillMaxWidth()
          .height(100.dp), // Set a fixed height for the thumbnail
      )
    }
  }
}
