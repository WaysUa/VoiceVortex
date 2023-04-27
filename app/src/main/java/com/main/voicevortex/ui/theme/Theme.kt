package com.main.voicevortex.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun VoiceVortexTheme(
    style: VoiceVortexStyle = VoiceVortexStyle.Purple,
    textSize: VoiceVortexSize = VoiceVortexSize.Medium,
    paddingSize: VoiceVortexSize = VoiceVortexSize.Medium,
    corners: VoiceVortexCorners = VoiceVortexCorners.Rounded,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = when (darkTheme) {
        true -> {
            when (style) {
                VoiceVortexStyle.Purple -> purpleDarkPalette
                VoiceVortexStyle.Blue -> blueDarkPalette
                VoiceVortexStyle.Orange -> orangeDarkPalette
                VoiceVortexStyle.Red -> redDarkPalette
                VoiceVortexStyle.Green -> greenDarkPalette
            }
        }
        false -> {
            when (style) {
                VoiceVortexStyle.Purple -> purpleLightPalette
                VoiceVortexStyle.Blue -> blueLightPalette
                VoiceVortexStyle.Orange -> orangeLightPalette
                VoiceVortexStyle.Red -> redLightPalette
                VoiceVortexStyle.Green -> greenLightPalette
            }
        }
    }

    val typography = VoiceVortexTypography(
        heading = TextStyle(
            fontSize = when (textSize) {
                VoiceVortexSize.Small -> 24.sp
                VoiceVortexSize.Medium -> 28.sp
                VoiceVortexSize.Big -> 32.sp
            },
            fontWeight = FontWeight.Bold
        ),
        body = TextStyle(
            fontSize = when (textSize) {
                VoiceVortexSize.Small -> 14.sp
                VoiceVortexSize.Medium -> 16.sp
                VoiceVortexSize.Big -> 18.sp
            },
            fontWeight = FontWeight.Normal
        ),
        toolbar = TextStyle(
            fontSize = when (textSize) {
                VoiceVortexSize.Small -> 14.sp
                VoiceVortexSize.Medium -> 16.sp
                VoiceVortexSize.Big -> 18.sp
            },
            fontWeight = FontWeight.Medium
        ),
        caption = TextStyle(
            fontSize = when (textSize) {
                VoiceVortexSize.Small -> 10.sp
                VoiceVortexSize.Medium -> 12.sp
                VoiceVortexSize.Big -> 14.sp
            }
        )
    )

    val shapes = VoiceVortexShape(
        padding = when (paddingSize) {
            VoiceVortexSize.Small -> 12.dp
            VoiceVortexSize.Medium -> 16.dp
            VoiceVortexSize.Big -> 20.dp
        },
        cornersStyle = when (corners) {
            VoiceVortexCorners.Flat -> RoundedCornerShape(0.dp)
            VoiceVortexCorners.Rounded -> RoundedCornerShape(8.dp)
        }
    )

    val images = VoiceVortexImage(
//        mainIcon = if (darkTheme) R.drawable.ic_baseline_mood_24 else R.drawable.ic_baseline_mood_bad_24,
        mainIconDescription = if (darkTheme) "Good Mood" else "Bad Mood"
    )

    CompositionLocalProvider(
        LocalVoiceVortexColors provides colors,
        LocalVoiceVortexTypography provides typography,
        LocalVoiceVortexShape provides shapes,
        LocalJetHabitImage provides images,
        content = content
    )
}