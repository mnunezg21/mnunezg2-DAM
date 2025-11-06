package com.antpaniagua.viewmodeltest25.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.antpaniagua.viewmodeltest25.viewmodels.DiceRollViewModel

@Composable
fun DiceApp(modifier: Modifier) {
    // Use the 'viewModel()' function from the lifecycle-viewmodel-compose artifact
    //La siguiente linea es la que declara el viewmodel que vamos a utilizar
    val viewModel: DiceRollViewModel = viewModel()

    Column(modifier = modifier.padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Prueba de ViewModel",
            fontSize = 24.sp,
        )
        DiceRollScreen(viewModel)
    }
}

@Composable
fun DiceRollScreen(viewModel: DiceRollViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState() //o obvserveastate, suscribe asstate, etc.
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.size(48.dp))
        Text(
            text = if (uiState.dado1 == uiState.dado2 && uiState.dado1 != null) "Iguales (${uiState.dado1})" else ""
        )
        Text(text = "Total de tiradas: ${uiState.totalTiradas}", fontSize = 20.sp, modifier = Modifier.clickable{viewModel.removeRollDice()})
        Spacer(modifier = Modifier.size(16.dp))
        Button(onClick = {
            viewModel.rollDice()
        }) {
            Text(text = "Tirar dados")
        }
    }
}