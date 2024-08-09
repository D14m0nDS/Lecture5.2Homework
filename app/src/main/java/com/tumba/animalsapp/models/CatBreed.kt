package com.tumba.animalsapp.models

data class CatBreed(
    override val name: String,
    override val imageResourceId: Int
) : AnimalBreed()