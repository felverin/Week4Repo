package com.fel.partygame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.fel.partygame.data.HeroData
import com.fel.partygame.ui.PartyRosterScreen
import com.fel.partygame.ui.theme.Week4Theme

class Partymanage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Week4Theme {
                PartyGameApp()
            }
        }
    }
}

@Composable
fun PartyGameApp() {
    var heroes by remember { mutableStateOf(HeroData.sampleHeroes) }

    PartyRosterScreen(
        heroes = heroes,
        onHealHero = { heroId ->
            heroes = heroes.map { hero ->
                if (hero.id == heroId) {
                    val newHp = (hero.currentHp + 250).coerceAtMost(hero.maxHp)
                    hero.copy(currentHp = newHp)
                } else {
                    hero
                }
            }
        },
        onToggleSquad = { heroId ->
            heroes = heroes.map { hero ->
                if (hero.id == heroId) {
                    hero.copy(isInSquad = !hero.isInSquad)
                } else {
                    hero
                }
            }
        },
        modifier = Modifier.fillMaxSize()
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PartyGameAppPreview() {
    Week4Theme {
        PartyGameApp()
    }
}
