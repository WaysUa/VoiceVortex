package com.main.voicevortex.base

interface EventHandler<T> {
    fun obtainEvent(event: T)
}