package com.tumba.animalsapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tumba.animalsapp.models.AnimalBreed


// The card for each breed of animal in the rows
@Composable
fun AnimalBreedCard(animalBreed: AnimalBreed) {
    Card(
        modifier = Modifier.padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = animalBreed.imageResourceId),
                contentDescription = "${animalBreed.name} image",
                modifier = Modifier.size(128.dp),
                contentScale = ContentScale.Crop
            )
            Text(text = animalBreed.name, style = MaterialTheme.typography.titleMedium, color = Color.Black)
        }
    }
}
