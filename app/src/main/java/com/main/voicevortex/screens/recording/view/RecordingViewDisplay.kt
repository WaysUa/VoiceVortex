package com.main.voicevortex.screens.recording.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.main.voicevortex.R
import com.main.voicevortex.ui.theme.baseDarkPalette
import com.main.voicevortex.ui.theme.orangeDarkPalette
import com.main.voicevortex.ui.views.RoundedIconButton

@Composable
fun RecordingViewDisplay(
    onRecordingClicked: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(baseDarkPalette.primaryBackground),
        contentAlignment = Alignment.BottomCenter
    ) {
        RoundedIconButton(
            onClick = { onRecordingClicked.invoke() },
            background = orangeDarkPalette.tintColor,
            size = 65.dp,
            modifier = Modifier.padding(bottom = 22.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_microphone),
                contentDescription = "Start recording"
            )
        }
    }
}