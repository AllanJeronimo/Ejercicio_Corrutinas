package com.example.corrutinasg8_2026_1.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.corrutinasg8_2026_1.ui.theme.CorrutinasG820261Theme
import com.example.corrutinasg8_2026_1.ui.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineName

@Composable
fun CoroutinesApp(mainViewModel: MainViewModel, modifier: Modifier) {

    var changeColor by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            onClick = { changeColor = !changeColor },
            colors = ButtonDefaults.buttonColors(
                if (changeColor) Color.Blue else Color.Red
            )
        ) {
            Text(text = "Cambio de Color")
        }

        Spacer(modifier = modifier.height(30.dp))

        Text(text = "Contador 1: ${mainViewModel.countTime1} [s]")
        Text(text = "Contador 2: ${mainViewModel.countTime2} [s]")
        Text(text = mainViewModel.resultState)

        Spacer(modifier = modifier.height(30.dp))

        Button(onClick = { mainViewModel.startCounters() }) {
            Text("Iniciar contadores")
        }
        Spacer(modifier = modifier.height(10.dp))

        Button(
            onClick = { mainViewModel.cancelCounters() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
        ) {
            Text("Cancelar procesos")
        }
    }
}
