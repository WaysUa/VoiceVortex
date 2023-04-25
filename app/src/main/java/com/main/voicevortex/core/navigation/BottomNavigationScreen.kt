package com.main.voicevortex.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationScreen(
    val id : String,
    val title : String,
    val icon : ImageVector
) {
    object Home : BottomNavigationScreen("recording", "Recording", Icons.Default.Home)
    object Search : BottomNavigationScreen("search", "Search", Icons.Default.Search)
    object Profile : BottomNavigationScreen("profile","Profile", Icons.Default.Person)
    object Setting : BottomNavigationScreen("setting","Setting", Icons.Default.Settings)

    object Items {
        val list = listOf(
            Home, Search, Profile, Setting
        )
    }
}