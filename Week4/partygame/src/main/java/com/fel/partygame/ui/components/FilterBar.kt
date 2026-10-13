package com.fel.partygame.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FilterBar(
    filters: List<String>,
    selectedIndex: Int,
    onFilterSelected: (Int) -> Unit,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        // Search Box
        Surface(
            shape = RoundedCornerShape(12.dp),
            color = Color(0xFF161824),
            border = BorderStroke(1.dp, Color(0xFF2A2D40)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 14.dp, vertical = 12.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = Color(0xFF64748B),
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Box(modifier = Modifier.weight(1f)) {
                    if (searchQuery.isEmpty()) {
                        Text(
                            text = "Search by hero name, class, or rarity...",
                            fontSize = 13.sp,
                            color = Color(0xFF64748B)
                        )
                    }
                    BasicTextField(
                        value = searchQuery,
                        onValueChange = onSearchQueryChange,
                        singleLine = true,
                        cursorBrush = SolidColor(Color(0xFFFACC15)),
                        textStyle = TextStyle(
                            fontSize = 13.sp,
                            color = Color.White
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        // Horizontal Scrollable Filter Chips
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(filters) { index, filterText ->
                val isSelected = index == selectedIndex
                val bgColor = if (isSelected) Color(0xFF3D3012) else Color(0xFF1E202E)
                val borderColor = if (isSelected) Color(0xFFCA8A04) else Color(0xFF2A2D40)
                val textColor = if (isSelected) Color(0xFFFACC15) else Color(0xFF94A3B8)

                Surface(
                    shape = RoundedCornerShape(50),
                    color = bgColor,
                    border = BorderStroke(1.dp, borderColor),
                    modifier = Modifier.clickable { onFilterSelected(index) }
                ) {
                    Text(
                        text = filterText,
                        fontSize = 12.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                        color = textColor,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }
            }

            // Sort Chip
            item {
                Surface(
                    shape = RoundedCornerShape(50),
                    color = Color(0xFF1E202E),
                    border = BorderStroke(1.dp, Color(0xFFCA8A04)),
                    modifier = Modifier.clickable { /* Sort toggle */ }
                ) {
                    Text(
                        text = "Sort: Power",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFACC15),
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }
            }
        }
    }
}
