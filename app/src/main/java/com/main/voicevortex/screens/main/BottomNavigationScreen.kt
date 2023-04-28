package com.main.voicevortex.screens.main

import com.main.voicevortex.base.ScreenRoute

sealed class BottomNavigationScreen(
    val id : String,
    val title : String
) {
    object Recording : BottomNavigationScreen(ScreenRoute.recordingScreenRoute, "Recording")
    object Listening : BottomNavigationScreen(ScreenRoute.listeningScreenRoute, "Listening")
}