package com.fel.partygame.model

data class Hero(
    val id: Int,
    val name: String,
    val rarity: String,
    val heroClass: String,
    val avatarRes: Int,
    val level: String,
    val cp: Int,
    val currentHp: Int,
    val maxHp: Int,
    val currentMp: Int,
    val maxMp: Int,
    val atk: Int,
    val def: Int,
    val crit: String,
    val spd: Int,
    val skillName: String,
    val skillDescription: String,
    val isInSquad: Boolean = false
)
