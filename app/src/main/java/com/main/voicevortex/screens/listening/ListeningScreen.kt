package com.main.voicevortex.screens.listening

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ListeningScreen() {
    LaunchedEffect(key1 = Unit, block = {
       Log.d("MyLog", "ListeningScreen")
    })

}