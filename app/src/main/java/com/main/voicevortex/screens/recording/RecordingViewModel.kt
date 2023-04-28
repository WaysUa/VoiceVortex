package com.main.voicevortex.screens.recording

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.main.voicevortex.base.EventHandler
import com.main.voicevortex.screens.recording.models.RecordingEvent
import com.main.voicevortex.screens.recording.models.RecordingViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecordingViewModel(

) : ViewModel(), EventHandler<RecordingEvent> {

    private val _recordingViewState: MutableLiveData<RecordingViewState> = MutableLiveData(RecordingViewState.Display)
    val recordingViewState: LiveData<RecordingViewState> = _recordingViewState

    override fun obtainEvent(event: RecordingEvent) {
        when (val currentState = _recordingViewState.value) {
            is RecordingViewState.Display -> reduce(event, currentState)
            is RecordingViewState.Recording -> TODO()
            else -> throw NotImplementedError("Unexpected recording state")
        }
    }

    private fun reduce(event: RecordingEvent, state: RecordingViewState) {
        when(event) {
            RecordingEvent.EnterScreen -> {
                _recordingViewState.value = RecordingViewState.Display
            }
        }
    }
}