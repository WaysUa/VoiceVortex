package com.main.voicevortex.domain

import com.main.voicevortex.ui.theme.VoiceVortexCorners
import com.main.voicevortex.ui.theme.VoiceVortexSize
import com.main.voicevortex.ui.theme.VoiceVortexStyle

data class SettingsBundle(
    val isDarkMode: Boolean,
    val textSize: VoiceVortexSize,
    val paddingSize: VoiceVortexSize,
    val cornerStyle: VoiceVortexCorners,
    val style: VoiceVortexStyle
)