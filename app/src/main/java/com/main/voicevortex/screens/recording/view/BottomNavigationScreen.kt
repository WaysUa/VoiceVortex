package com.main.voicevortex.screens.recording.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.main.voicevortex.base.ScreenRoute

sealed class BottomNavigationScreen(
    val id : String,
    val title : String,
    val icon : ImageVector
) {
    object Recording : BottomNavigationScreen(ScreenRoute.recordingScreenRoute, "Recording", Icons.Default.Home)
    object Listening : BottomNavigationScreen(ScreenRoute.listeningScreenRoute, "Listening", Icons.Default.Search)

    object Items {
        val list = listOf(Recording, Listening)
    }
}