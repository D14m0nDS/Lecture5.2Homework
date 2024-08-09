package com.tumba.animalsapp.models

data class DogBreed(
    override val name: String,
    override val imageResourceId: Int
) : AnimalBreed()