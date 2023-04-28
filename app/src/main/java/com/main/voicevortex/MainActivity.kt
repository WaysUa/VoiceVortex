package com.main.voicevortex

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.main.voicevortex.base.ScreenRoute
import com.main.voicevortex.domain.SettingsBundle
import com.main.voicevortex.screens.main.MainScreen
import com.main.voicevortex.screens.recording.RecordingViewModel
import com.main.voicevortex.ui.theme.VoiceVortexCorners
import com.main.voicevortex.ui.theme.VoiceVortexSize
import com.main.voicevortex.ui.theme.VoiceVortexStyle
import com.main.voicevortex.ui.theme.VoiceVortexTheme
import com.main.voicevortex.ui.theme.baseDarkPalette
import com.main.voicevortex.ui.theme.baseLightPalette
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val recordingViewModel = hiltViewModel<RecordingViewModel>()

            val currentStyle = remember { mutableStateOf(VoiceVortexStyle.Purple) }
            val currentFontSize = remember { mutableStateOf(VoiceVortexSize.Medium) }
            val currentPaddingSize = remember { mutableStateOf(VoiceVortexSize.Medium) }
            val currentCornersStyle = remember { mutableStateOf(VoiceVortexCorners.Rounded) }
            val isDarkMode = remember { mutableStateOf(true) }

            VoiceVortexTheme(
                style = currentStyle.value,
                darkTheme = isDarkMode.value,
                textSize = currentFontSize.value,
                corners = currentCornersStyle.value,
                paddingSize = currentPaddingSize.value
            ) {
                val navController = rememberNavController()
                val systemUiController = rememberSystemUiController()

                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = if (isDarkMode.value) baseDarkPalette.primaryBackground else baseLightPalette.primaryBackground,
                        darkIcons = !isDarkMode.value
                    )
                }

                Surface {
                    NavHost(navController = navController, startDestination = ScreenRoute.recordingScreenRoute) {
                        composable(ScreenRoute.recordingScreenRoute) {
                            val settings = SettingsBundle(
                                isDarkMode = isDarkMode.value,
                                style = currentStyle.value,
                                textSize = currentFontSize.value,
                                cornerStyle = currentCornersStyle.value,
                                paddingSize = currentPaddingSize.value
                            )

                            MainScreen(
                                navController = navController,
                                settings = settings,
                                recordingViewModel = recordingViewModel
                            )
                        }
                    }
                }
            }
        }
    }
}