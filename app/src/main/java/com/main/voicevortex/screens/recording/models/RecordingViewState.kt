package com.main.voicevortex.screens.recording.models

sealed class RecordingViewState {
    object Display : RecordingViewState()
    object Recording : RecordingViewState()
}