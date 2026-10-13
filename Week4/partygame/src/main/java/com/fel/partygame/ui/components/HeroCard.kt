package com.fel.partygame.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fel.partygame.model.Hero

@Composable
fun HeroCard(
    hero: Hero,
    isExpanded: Boolean,
    onCardClick: () -> Unit,
    onHealClick: () -> Unit,
    onToggleSquadClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val classStyle = getClassTagStyle(hero.heroClass)
    val rarityStyle = getRarityTagStyle(hero.rarity)

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF161824)),
        border = BorderStroke(1.dp, if (hero.isInSquad) Color(0xFFEAB308) else Color(0xFF2A2D40)),
        modifier = modifier
            .fillMaxWidth()
            .clickable { onCardClick() }
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Header Row: Badges and CP
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Rarity Badge
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = rarityStyle.bg
                    ) {
                        Text(
                            text = hero.rarity,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = rarityStyle.text,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                        )
                    }

                    // Class Badge
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = classStyle.bg
                    ) {
                        Text(
                            text = hero.heroClass,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = classStyle.text,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                        )
                    }
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (hero.isInSquad) {
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = Color(0xFF854D0E)
                        ) {
                            Text(
                                text = "IN SQUAD",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFFEF08A),
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                            )
                        }
                    }

                    Text(
                        text = "⚔ ${hero.cp} CP",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFACC15)
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Main Info Row: Avatar + Stats
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Avatar with Level Tag
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFF1E2130))
                ) {
                    Image(
                        painter = painterResource(id = hero.avatarRes),
                        contentDescription = hero.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )

                    Surface(
                        shape = RoundedCornerShape(4.dp),
                        color = Color(0xFF0F111A).copy(alpha = 0.85f),
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(4.dp)
                    ) {
                        Text(
                            text = hero.level,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                        )
                    }
                }

                // Details Column
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 14.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = hero.name,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )

                        Icon(
                            imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                            contentDescription = "Expand",
                            tint = Color(0xFF94A3B8),
                            modifier = Modifier.size(24.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // HP Bar Row
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "HP",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF94A3B8),
                            modifier = Modifier.width(26.dp)
                        )

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(7.dp)
                                .clip(RoundedCornerShape(4.dp))
                                .background(Color(0xFF272A3C))
                        ) {
                            val ratio = (hero.currentHp.toFloat() / hero.maxHp.toFloat()).coerceIn(0f, 1f)
                            Box(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .fillMaxWidth(ratio)
                                    .background(Color(0xFFEF4444), RoundedCornerShape(4.dp))
                            )
                        }

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = "${hero.currentHp} / ${hero.maxHp}",
                            fontSize = 11.sp,
                            color = Color(0xFFCBD5E1)
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    // MP Bar Row
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "MP",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF94A3B8),
                            modifier = Modifier.width(26.dp)
                        )

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(7.dp)
                                .clip(RoundedCornerShape(4.dp))
                                .background(Color(0xFF272A3C))
                        ) {
                            val ratio = (hero.currentMp.toFloat() / hero.maxMp.toFloat()).coerceIn(0f, 1f)
                            Box(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .fillMaxWidth(ratio)
                                    .background(Color(0xFF3B82F6), RoundedCornerShape(4.dp))
                            )
                        }

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = "${hero.currentMp} / ${hero.maxMp}",
                            fontSize = 11.sp,
                            color = Color(0xFFCBD5E1)
                        )
                    }
                }
            }

            // Expanded Stats & Skill Dropdown View
            AnimatedVisibility(visible = isExpanded) {
                Column(
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    // 4 Stat Cards Grid
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        StatBox("ATK", hero.atk.toString(), Modifier.weight(1f))
                        StatBox("DEF", hero.def.toString(), Modifier.weight(1f))
                        StatBox("CRIT", hero.crit, Modifier.weight(1f))
                        StatBox("SPD", hero.spd.toString(), Modifier.weight(1f))
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // Skill Info Surface
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = Color(0xFF1E2130),
                        border = BorderStroke(1.dp, Color(0xFF2A2D40)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(14.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text("★", fontSize = 14.sp, color = Color(0xFFFACC15))
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = hero.skillName,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFFACC15)
                                )
                            }
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = hero.skillDescription,
                                fontSize = 12.sp,
                                color = Color(0xFF94A3B8),
                                lineHeight = 18.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    // Action Buttons Row
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        // Heal Button
                        Button(
                            onClick = onHealClick,
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF064E3B)),
                            border = BorderStroke(1.dp, Color(0xFF059669)),
                            modifier = Modifier
                                .weight(1f)
                                .height(44.dp)
                        ) {
                            Text(
                                text = "🧪 Heal (+250 HP)",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF34D399)
                            )
                        }

                        // Add/Remove Squad Button
                        Button(
                            onClick = onToggleSquadClick,
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (hero.isInSquad) Color(0xFF3B2304) else Color(0xFF78350F)
                            ),
                            border = BorderStroke(1.dp, Color(0xFFCA8A04)),
                            modifier = Modifier
                                .weight(1f)
                                .height(44.dp)
                        ) {
                            Text(
                                text = if (hero.isInSquad) "⚔ Remove Squad" else "⚔ Add to Squad",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFFACC15)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun StatBox(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(10.dp),
        color = Color(0xFF1E2130),
        border = BorderStroke(1.dp, Color(0xFF2A2D40)),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = label,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF64748B)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = value,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

data class ClassTagStyle(val bg: Color, val text: Color)

fun getClassTagStyle(heroClass: String): ClassTagStyle {
    return when (heroClass) {
        "High Templar" -> ClassTagStyle(Color(0xFF3B2304), Color(0xFFFDE047))
        "Divine Oracle" -> ClassTagStyle(Color(0xFF064E3B), Color(0xFF6EE7B7))
        "Shadowblade" -> ClassTagStyle(Color(0xFF4C1D95), Color(0xFFD8B4FE))
        "Archmage" -> ClassTagStyle(Color(0xFF164E63), Color(0xFF67E8F9))
        else -> ClassTagStyle(Color(0xFF7C2D12), Color(0xFFFDBA74))
    }
}

data class RarityTagStyle(val bg: Color, val text: Color)

fun getRarityTagStyle(rarity: String): RarityTagStyle {
    return when (rarity) {
        "MYTHIC" -> RarityTagStyle(Color(0xFF881337), Color(0xFFFDA4AF))
        else -> RarityTagStyle(Color(0xFF78350F), Color(0xFFFDE047))
    }
}
