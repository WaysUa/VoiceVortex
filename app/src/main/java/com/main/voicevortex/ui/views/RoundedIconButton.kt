package com.main.voicevortex.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.main.voicevortex.ui.theme.VoiceVortexStyle
import com.main.voicevortex.ui.theme.orangeDarkPalette

@Composable
fun RoundedIconButton(
    onClick: () -> Unit,
    background: Color,
    size: Dp,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .background(background)
    ) {
        content()
    }
}