package com.tumba.animalsapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tumba.animalsapp.models.DogBreed
import com.tumba.animalsapp.R
import com.tumba.animalsapp.models.CatBreed


// Lists with dog and cat breeds
val  dogBreeds = listOf(
    DogBreed("Golden Retriever", R.drawable.golden_retriever_dog),
    DogBreed("Husky", R.drawable.husky_dog),
    DogBreed("Dachshund", R.drawable.dachshund_dog),
    DogBreed("Samoyed", R.drawable.samoyed_dog),
    DogBreed("King Charles Spaniel", R.drawable.king_charles_spaniel_dog),
    DogBreed("Shiba Inu", R.drawable.shiba_inu_dog)
)

val  catBreeds = listOf(
    CatBreed("Siamese", R.drawable.siamese_cat),
    CatBreed("Persian", R.drawable.persian_cat),
    CatBreed("Norwegian Forest", R.drawable.norwegian_forest_cat),
    CatBreed("Ragdoll", R.drawable.ragdoll_cat),
    CatBreed("Scottish Fold", R.drawable.scottish_fold_cat)
)

val allBreeds = dogBreeds + catBreeds

// First row with all breeds
@Composable
fun AllBreedsRow() {
    LazyRow(
        content = {
            items(allBreeds.size) { index ->
                AnimalBreedCard(animalBreed = allBreeds[index])
            }
        }

    )
}

// Second row with filters for dog and cat breeds
@Composable
fun FilteredBreedsRow() {
    var selectedCategory by remember { mutableStateOf("all") }

    // Filter breeds based on the selected category
    val filteredBreeds = when (selectedCategory) {
        "dogs" -> dogBreeds
        "cats" -> catBreeds
        else -> allBreeds
    }

    // Display the filtered breeds + the toggle buttons on top
    Column {
        Row(modifier = Modifier.padding(8.dp)) {
            ToggleButton("Dogs", selectedCategory == "dogs") {
                selectedCategory = if (selectedCategory == "dogs") "all" else "dogs"
            }
            Spacer(modifier = Modifier.width(16.dp))
            ToggleButton("Cats", selectedCategory == "cats") {
                selectedCategory = if (selectedCategory == "cats") "all" else "cats"
            }
        }

        LazyRow {
            items(filteredBreeds.size) { index ->
                AnimalBreedCard(animalBreed = filteredBreeds[index])
            }
        }
    }
}

// The button component for filtering breeds
@Composable
fun ToggleButton(text: String, isSelected: Boolean, onClick: () -> Unit) {
    Button(
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) Color.Blue else Color.Gray
        )
    ) {
        Text(text = text, color = Color.White)
    }
}