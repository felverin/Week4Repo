package com.fel.week4.model

data class Car(
    val id: Int,
    val name: String,
    val imageRes: Int,
    val fuelBadge: String,
    val transmission: String,
    val year: String,
    val mileage: String,
    val price: String,
    val location: String,
    val fuelType: String,
    val description: String,
    val isFavorite: Boolean = false
)
