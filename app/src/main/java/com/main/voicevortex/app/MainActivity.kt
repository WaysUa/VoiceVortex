package com.main.voicevortex.app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.main.voicevortex.core.navigation.Navigation
import com.main.voicevortex.core.navigation.BottomNavigationScreen
import com.main.voicevortex.core.base.BaseActivity
import com.main.voicevortex.core.navigation.CustomBottomNavigation

class MainActivity : BaseActivity() {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val currentBottomNavigationScreen = remember {
                mutableStateOf<BottomNavigationScreen>(BottomNavigationScreen.Home)
            }

            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                Scaffold(
                    bottomBar = {
                        CustomBottomNavigation(currentScreenId = currentBottomNavigationScreen.value.id) {
                            currentBottomNavigationScreen.value = it
                            navController.navigate(currentBottomNavigationScreen.value.id)
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                        .padding(bottom = 4.dp)
                ) {
                    Navigation(navController = navController)
                }
            }
        }
    }
}