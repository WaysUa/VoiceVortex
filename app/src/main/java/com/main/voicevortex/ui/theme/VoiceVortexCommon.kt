package com.main.voicevortex.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp

data class VoiceVortexColors(
    val primaryText: Color,
    val primaryBackground: Color,
    val secondaryText: Color,
    val secondaryBackground: Color,
    val tintColor: Color,
    val controlColor: Color,
    val errorColor: Color
)

data class VoiceVortexTypography(
    val heading: TextStyle,
    val body: TextStyle,
    val toolbar: TextStyle,
    val caption: TextStyle
)

data class VoiceVortexShape(
    val padding: Dp,
    val cornersStyle: Shape
)

data class VoiceVortexImage(
    //todo correct
    val mainIcon: Int = 0,
    val mainIconDescription: String
)

object VoiceVortexTheme {
    val colors: VoiceVortexColors
        @Composable
        get() = LocalVoiceVortexColors.current

    val typography: VoiceVortexTypography
        @Composable
        get() = LocalVoiceVortexTypography.current

    val shapes: VoiceVortexShape
        @Composable
        get() = LocalVoiceVortexShape.current

    val images: VoiceVortexImage
        @Composable
        get() = LocalJetHabitImage.current
}

enum class VoiceVortexStyle {
    Purple, Orange, Blue, Red, Green
}

enum class VoiceVortexSize {
    Small, Medium, Big
}

enum class VoiceVortexCorners {
    Flat, Rounded
}

val LocalVoiceVortexColors = staticCompositionLocalOf<VoiceVortexColors> {
    error("No colors provided")
}

val LocalVoiceVortexTypography = staticCompositionLocalOf<VoiceVortexTypography> {
    error("No font provided")
}

val LocalVoiceVortexShape = staticCompositionLocalOf<VoiceVortexShape> {
    error("No shapes provided")
}

val LocalJetHabitImage = staticCompositionLocalOf<VoiceVortexImage> {
    error("No images provided")
}