package com.fel.week4.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.fel.week4.data.CarData
import com.fel.week4.model.Car
import com.fel.week4.ui.theme.Week4Theme

@Composable
fun CarCard(
    car: Car,
    onCarClick: (Car) -> Unit,
    onToggleFavorite: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val (fuelBg, fuelText) = getFuelBadgeColors(car.fuelBadge)

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier
            .fillMaxWidth()
            .clickable { onCarClick(car) }
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Image with badge
            Box(
                modifier = Modifier
                    .size(width = 110.dp, height = 90.dp)
                    .clip(RoundedCornerShape(12.dp))
            ) {
                Image(
                    painter = painterResource(id = car.imageRes),
                    contentDescription = car.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = fuelBg,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(6.dp)
                ) {
                    Text(
                        text = car.fuelBadge,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = fuelText,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }

            // Info column
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 12.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = car.name,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF111827),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f)
                    )
                    IconButton(
                        onClick = { onToggleFavorite(car.id) },
                        modifier = Modifier.size(28.dp)
                    ) {
                        Icon(
                            imageVector = if (car.isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                            contentDescription = "Favorite",
                            tint = if (car.isFavorite) Color(0xFFFF5232) else Color(0xFF9CA3AF),
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(2.dp))

                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = Color(0xFFF3F4F6)
                ) {
                    Text(
                        text = car.transmission,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF6B7280),
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(6.dp)
                                .background(Color(0xFFFF5232), CircleShape)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = car.year,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF111827)
                        )
                    }

                    Text(
                        text = car.mileage,
                        fontSize = 12.sp,
                        color = Color(0xFF6B7280)
                    )
                }
            }
        }
    }
}

fun getFuelBadgeColors(badge: String): Pair<Color, Color> {
    return when (badge.uppercase()) {
        "PHEV" -> Pair(Color(0xFFECE6FA), Color(0xFF6B46C1))
        "HYBRID" -> Pair(Color(0xFFD1FAE5), Color(0xFF047857))
        "ELECTRIC" -> Pair(Color(0xFFCFFAFE), Color(0xFF0E7490))
        else -> Pair(Color(0xFFFEF3C7), Color(0xFFB45309))
    }
}

@Preview(showBackground = true)
@Composable
fun CarCardPreview() {
    Week4Theme {
        CarCard(
            car = CarData.sampleCars[4],
            onCarClick = {},
            onToggleFavorite = {},
            modifier = Modifier.padding(16.dp)
        )
    }
}
