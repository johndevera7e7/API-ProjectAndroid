package com.example.api_list_googlemaps.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.api_list_googlemaps.model.Data
import com.example.api_list_googlemaps.model.Item

@Composable
fun NasaItem(itemData: Item, onItemClick: (Data) -> Unit) {
    val data = itemData.data.firstOrNull()
    val imageUrl = itemData.links.firstOrNull { it.render == "image" }?.href
    if (data != null && imageUrl != null) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable { onItemClick(itemData.data.first()) },
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = data.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
                Text(text = data.title)
                Text(text = data.description)
            }
        }
    }
}