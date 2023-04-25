package com.main.voicevortex.core.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.main.voicevortex.features.voice_recording.presentation.ui.AnotherScreen
import com.main.voicevortex.features.voice_recording.presentation.ui.VoiceRecordingScreen

@Composable
fun Navigation(navController : NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavigationScreen.Home.id
    ) {
        composable(BottomNavigationScreen.Home.id) {
            VoiceRecordingScreen()
        }
        composable(BottomNavigationScreen.Search.id) {
            AnotherScreen()
        }
        composable(BottomNavigationScreen.Setting.id) {
            Log.d("MyLog", "Settings")
        }
        composable(BottomNavigationScreen.Profile.id) {
            Log.d("MyLog", "Profile")
        }
    }
}