package com.fel.week4

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.fel.week4.data.CarData
import com.fel.week4.ui.CarDetailScreen
import com.fel.week4.ui.CarListScreen
import com.fel.week4.ui.theme.Week4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Week4Theme {
                CarDealerApp()
            }
        }
    }
}

@Composable
fun CarDealerApp() {
    val context = LocalContext.current
    var cars by remember { mutableStateOf(CarData.sampleCars) }
    var selectedCarId by remember { mutableStateOf<Int?>(null) }

    fun toggleFavorite(carId: Int) {
        cars = cars.map { car ->
            if (car.id == carId) {
                car.copy(isFavorite = !car.isFavorite)
            } else {
                car
            }
        }
    }

    val selectedCar = cars.find { it.id == selectedCarId }

    if (selectedCar != null) {
        BackHandler {
            selectedCarId = null
        }
        CarDetailScreen(
            car = selectedCar,
            onBack = { selectedCarId = null },
            onToggleFavorite = { id -> toggleFavorite(id) },
            onContactSeller = { car ->
                Toast.makeText(context, "Contacting seller for ${car.name}", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier.fillMaxSize()
        )
    } else {
        CarListScreen(
            cars = cars,
            onCarClick = { car -> selectedCarId = car.id },
            onToggleFavorite = { id -> toggleFavorite(id) },
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CarDealerAppPreview() {
    Week4Theme {
        CarDealerApp()
    }
}
