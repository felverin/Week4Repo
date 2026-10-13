package com.fel.partygame.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fel.partygame.data.HeroData
import com.fel.partygame.model.Hero
import com.fel.partygame.ui.components.FilterBar
import com.fel.partygame.ui.components.HeroCard
import com.fel.partygame.ui.components.SquadHeaderCard
import com.fel.partygame.ui.theme.Week4Theme

@Composable
fun PartyRosterScreen(
    heroes: List<Hero>,
    onHealHero: (Int) -> Unit,
    onToggleSquad: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedFilterIndex by remember { mutableIntStateOf(0) }
    var expandedHeroId by remember { mutableStateOf<Int?>(1) } // Alistair expanded by default

    val filterOptions = listOf(
        "All (14)",
        "Berserker (2)",
        "Archmage (3)",
        "Shadowblade (2)",
        "Templar (2)"
    )

    val squadHeroes = heroes.filter { it.isInSquad }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF0F111A))
            .statusBarsPadding()
    ) {
        // Top Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Party Roster",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "Guild Vanguard • 14 Heroes Available",
                    fontSize = 13.sp,
                    color = Color(0xFF94A3B8)
                )
            }

            Surface(
                shape = RoundedCornerShape(50),
                color = Color(0xFF2D1E08),
                border = BorderStroke(1.dp, Color(0xFFCA8A04)),
                modifier = Modifier.clickable { /* Expedition action */ }
            ) {
                Text(
                    text = "★ Expedition",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFACC15),
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp)
                )
            }
        }

        // Scrollable Main Content
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Squad Header Card item
            item {
                SquadHeaderCard(
                    squadHeroes = squadHeroes,
                    onDeployClick = { },
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
            }

            // Filter Bar item
            item {
                FilterBar(
                    filters = filterOptions,
                    selectedIndex = selectedFilterIndex,
                    onFilterSelected = { selectedFilterIndex = it },
                    searchQuery = searchQuery,
                    onSearchQueryChange = { searchQuery = it }
                )
            }

            // Hero Cards items
            items(
                items = heroes,
                key = { it.id }
            ) { hero ->
                HeroCard(
                    hero = hero,
                    isExpanded = expandedHeroId == hero.id,
                    onCardClick = {
                        expandedHeroId = if (expandedHeroId == hero.id) null else hero.id
                    },
                    onHealClick = { onHealHero(hero.id) },
                    onToggleSquadClick = { onToggleSquad(hero.id) },
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PartyRosterScreenPreview() {
    Week4Theme {
        PartyRosterScreen(
            heroes = HeroData.sampleHeroes,
            onHealHero = {},
            onToggleSquad = {}
        )
    }
}
