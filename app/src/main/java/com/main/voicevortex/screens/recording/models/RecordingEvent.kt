package com.main.voicevortex.screens.recording.models

sealed class RecordingEvent {
    object EnterScreen : RecordingEvent()
    object RecordingScreen : RecordingEvent()
}