package com.main.voicevortex.screens.recording

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import com.main.voicevortex.screens.recording.models.RecordingEvent
import com.main.voicevortex.screens.recording.models.RecordingViewState
import com.main.voicevortex.screens.recording.view.RecordingViewDisplay
import com.main.voicevortex.screens.recording.view.RecordingViewRecording

@Composable
fun RecordingScreen(
    recordingViewModel: RecordingViewModel
) {
    val viewState = recordingViewModel.recordingViewState.observeAsState()

    when (val state = viewState.value) {
        RecordingViewState.Display -> RecordingViewDisplay {
            recordingViewModel.obtainEvent(RecordingEvent.RecordingScreen)
        }
        RecordingViewState.Recording -> RecordingViewRecording()
        else -> throw NotImplementedError("Unexpected recording state")
    }

    LaunchedEffect(key1 = viewState, block = {
        recordingViewModel.obtainEvent(RecordingEvent.EnterScreen)
    })
}