package com.example.corrutinasg8_2026_1.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class MainViewModel : ViewModel() {

    var resultState by mutableStateOf("")
        private set

    var countTime1 by mutableStateOf(0)
        private set

    var countTime2 by mutableStateOf(0)
        private set
    private var job: Job? = null

    private suspend fun runCounterOne() {
        for (i in 1..5) {
            delay(1000)
            countTime1 = i
        }
    }

    private suspend fun runCounterTwo() {
        for (i in 1..5) {
            delay(1000)
            countTime2 = i
        }
    }

    fun startCounters() {
        resultState = "Iniciando contadores..."
        job = viewModelScope.launch {
            runCounterOne()
            resultState = "Primer contador terminado. Iniciando segundo..."
            runCounterTwo()
            resultState = "Proceso completo ✅"
        }
    }

    fun cancelCounters() {
        job?.cancel()
        resultState = "Procesos cancelados ❌"
    }
}
