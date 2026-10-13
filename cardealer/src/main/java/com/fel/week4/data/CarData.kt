package com.fel.week4.data

import com.fel.week4.R
import com.fel.week4.model.Car

object CarData {
    val sampleCars = listOf(
        Car(
            id = 1,
            name = "Chery Tiggo 9 CSH",
            imageRes = R.drawable.tiggo,
            fuelBadge = "PHEV",
            transmission = "Auto",
            year = "2024",
            mileage = "5,000 km",
            price = "Rp 485.000.000",
            location = "Jakarta",
            fuelType = "PHEV",
            description = "The Chery Tiggo 9 CSH is a flagship SUV delivering exceptional plug-in hybrid performance, luxurious 7-seater interior, panoramic sunroof, and state-of-the-art driver assistance technology.",
            isFavorite = true
        ),
        Car(
            id = 2,
            name = "Honda CRV",
            imageRes = R.drawable.crv,
            fuelBadge = "PETROL",
            transmission = "Auto",
            year = "2013",
            mileage = "15,200 km",
            price = "Rp 185.000.000",
            location = "Jakarta",
            fuelType = "Petrol",
            description = "The Honda CR-V is a highly reliable mid-size SUV offering impressive cabin space, smooth automatic transmission, comfortable riding quality, and time-tested Honda reliability.",
            isFavorite = false
        ),
        Car(
            id = 3,
            name = "Toyota Yaris Cross",
            imageRes = R.drawable.yariscross,
            fuelBadge = "HYBRID",
            transmission = "Auto",
            year = "2024",
            mileage = "30,500 km",
            price = "Rp 340.000.000",
            location = "Surabaya",
            fuelType = "Hybrid",
            description = "Toyota Yaris Cross Hybrid combines compact crossover utility with eco-friendly hybrid efficiency. Features include Toyota Safety Sense, modern touchscreen infotainment, and superior fuel economy.",
            isFavorite = true
        ),
        Car(
            id = 4,
            name = "Daihatsu Xenia",
            imageRes = R.drawable.xenia,
            fuelBadge = "PETROL",
            transmission = "Manual",
            year = "2022",
            mileage = "28,000 km",
            price = "Rp 165.000.000",
            location = "Bandung",
            fuelType = "Petrol",
            description = "Daihatsu Xenia is Indonesia's favorite family MPV. Designed with spacious 3-row seating, fuel-efficient dual VVT-i engine, and affordable maintenance costs.",
            isFavorite = false
        ),
        Car(
            id = 5,
            name = "Toyota Yaris",
            imageRes = R.drawable.yaris,
            fuelBadge = "PETROL",
            transmission = "Auto",
            year = "2021",
            mileage = "52,400 km",
            price = "Rp 245.000.000",
            location = "Semarang",
            fuelType = "Petrol",
            description = "The Toyota Yaris G AT is a sporty compact hatchback that punches above its weight class. Equipped with a 1.5L dual VVT-i engine, 7 airbags, pre-collision system, and a floating head unit, it offers premium features at a very accessible price point.",
            isFavorite = true
        ),
        Car(
            id = 6,
            name = "Honda HR-V",
            imageRes = R.drawable.hrv,
            fuelBadge = "PETROL",
            transmission = "Auto",
            year = "2020",
            mileage = "42,000 km",
            price = "Rp 225.000.000",
            location = "Yogyakarta",
            fuelType = "Petrol",
            description = "The Honda HR-V offers stylish coupe-like SUV design, magic seat versatility, responsive performance, and a comprehensive suite of safety features for urban drives.",
            isFavorite = true
        ),
        Car(
            id = 7,
            name = "Toyota Innova Reborn",
            imageRes = R.drawable.reborn,
            fuelBadge = "PETROL",
            transmission = "Manual",
            year = "2019",
            mileage = "65,000 km",
            price = "Rp 290.000.000",
            location = "Solo",
            fuelType = "Diesel",
            description = "Toyota Kijang Innova Reborn provides unparalleled comfort for long-distance family road trips, powerful engine output, robust ladder-frame chassis, and spacious interior.",
            isFavorite = true
        ),
        Car(
            id = 8,
            name = "MG 4 EV",
            imageRes = R.drawable.mg4,
            fuelBadge = "ELECTRIC",
            transmission = "Auto",
            year = "2023",
            mileage = "12,000 km",
            price = "Rp 410.000.000",
            location = "Tangerang",
            fuelType = "Electric",
            description = "The MG 4 EV is a futuristic zero-emission hatchback boasting dynamic rear-wheel drive handling, rapid DC charging capabilities, and cutting-edge digital cockpit technology.",
            isFavorite = false
        ),
        Car(
            id = 9,
            name = "Daihatsu Ayla",
            imageRes = R.drawable.ayla,
            fuelBadge = "PETROL",
            transmission = "Manual",
            year = "2022",
            mileage = "18,000 km",
            price = "Rp 115.000.000",
            location = "Malang",
            fuelType = "Petrol",
            description = "Daihatsu Ayla is a highly maneuverable and economical city car. Extremely nimble in city traffic with ultra-low fuel consumption and low cost of ownership.",
            isFavorite = false
        ),
        Car(
            id = 10,
            name = "JAC J5",
            imageRes = R.drawable.j5,
            fuelBadge = "PETROL",
            transmission = "Auto",
            year = "2023",
            mileage = "8,000 km",
            price = "Rp 310.000.000",
            location = "Bekasi",
            fuelType = "Petrol",
            description = "Modern compact SUV with sleek styling, premium leather interior, digital instrument cluster, and smooth automatic transmission for a comfortable daily commute.",
            isFavorite = false
        )
    )
}
