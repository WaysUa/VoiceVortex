package com.main.voicevortex.screens.recording

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.main.voicevortex.R
import com.main.voicevortex.domain.SettingsBundle
import com.main.voicevortex.ui.theme.baseDarkPalette
import com.main.voicevortex.ui.theme.orangeDarkPalette
import com.main.voicevortex.ui.views.RoundedIconButton

@Composable
fun RecordingScreen(
    settings: SettingsBundle
) {
    val isVisibilityState = remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(baseDarkPalette.primaryBackground),
        contentAlignment = Alignment.BottomCenter
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 22.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (isVisibilityState.value) {
                RoundedIconButton(
                    onClick = { /*TODO*/ },
                    background = baseDarkPalette.secondaryText,
                    size = 50.dp,
                    modifier = Modifier.padding(top = 5.dp, end = 10.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_cancel),
                        contentDescription = "Start recording"
                    )
                }
            }

            RoundedIconButton(
                onClick = { isVisibilityState.value = !isVisibilityState.value },
                background = orangeDarkPalette.tintColor,
                size = 65.dp
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_microphone),
                    contentDescription = "Start recording"
                )
            }

            if (isVisibilityState.value) {
                RoundedIconButton(
                    onClick = { /*TODO*/ },
                    background = baseDarkPalette.secondaryText,
                    size = 50.dp,
                    modifier = Modifier.padding(top = 5.dp, start = 10.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_save),
                        contentDescription = "Start recording"
                    )
                }
            }
        }
    }
}