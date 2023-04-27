package com.main.voicevortex.screens.main

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.main.voicevortex.domain.SettingsBundle
import com.main.voicevortex.screens.listening.ListeningScreen
import com.main.voicevortex.screens.recording.RecordingScreen
import com.main.voicevortex.screens.recording.view.BottomNavigationScreen
import com.main.voicevortex.ui.theme.VoiceVortexTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(
    navController: NavController,
    settings: SettingsBundle,
) {
    val childNavController = rememberNavController()
    val currentBottomNavigationScreen = remember {
        mutableStateOf<BottomNavigationScreen>(BottomNavigationScreen.Recording)
    }
    val items = listOf(BottomNavigationScreen.Recording, BottomNavigationScreen.Listening)

    Column {
        Box(modifier = Modifier.weight(1f)) {
            NavHost(
                navController = childNavController,
                startDestination = BottomNavigationScreen.Recording.id
            ) {
                composable(BottomNavigationScreen.Recording.id) {
                    RecordingScreen()
                }

                composable(BottomNavigationScreen.Listening.id) {
                    ListeningScreen()
                }
            }
        }
        Box(
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth()
        ) {
            BottomNavigation {
                val navBackStackEntry by childNavController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                val previousDestination = remember { mutableStateOf(items.first().id) }

                items.forEach { screen ->
                    val isSelected =
                        currentDestination?.hierarchy?.any { it.route == screen.id } == true

                    BottomNavigationItem(
                        modifier = Modifier.background(VoiceVortexTheme.colors.primaryBackground),
                        icon = {
                            Icon(
                                imageVector = when (screen) {
                                    BottomNavigationScreen.Recording -> Icons.Filled.Favorite
                                    BottomNavigationScreen.Listening -> Icons.Filled.Settings
                                },
                                contentDescription = null,
                                tint = if (isSelected) VoiceVortexTheme.colors.tintColor else VoiceVortexTheme.colors.controlColor
                            )
                        },
                        label = {
                            Text(
                                text = screen.title,
                                color = if (isSelected) VoiceVortexTheme.colors.primaryText else VoiceVortexTheme.colors.controlColor
                            )
                        },
                        selected = isSelected,
                        onClick = {
                            if (screen.id == previousDestination.value) return@BottomNavigationItem
                            previousDestination.value = screen.id

                            childNavController.navigate(screen.id) {
                                popUpTo(childNavController.graph.findStartDestination().id) {
                                    saveState = true
                                }

                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    }
}