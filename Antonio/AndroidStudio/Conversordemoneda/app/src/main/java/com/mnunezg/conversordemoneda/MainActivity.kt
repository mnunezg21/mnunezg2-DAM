package com.mnunezg.conversordemoneda

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.mnunezg.conversordemoneda.ui.theme.ConversorDeMonedaTheme

// Mario Núñez García
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConversorDeMonedaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(name: String, modifier: Modifier = Modifier) {
    var numero by rememberSaveable { mutableStateOf(5.0f) }
    var monedaSeleccionada by rememberSaveable { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Conversor de moneda",
            fontSize = 32.sp,
        )
        Text(
            text = numero.toString() + tipoMoneda(monedaSeleccionada),
            fontSize = 28.sp
        )
        TextField(
            value = numero.toString(),
            label = { Text("Introduce el valor inicial: ") },
            onValueChange = {
                numero = it.toFloat()

            }
        )
        Row {
            conversorEuro(
                monedaSeleccionada,
                convertir = { numero *= 0.85f },
                cambiarMoneda = { monedaSeleccionada = true})
            conversorDolar(
                monedaSeleccionada,
                convertir = { numero *= 1.15f },
                cambiarMoneda = { monedaSeleccionada = false})
        }
    }
}

private fun tipoMoneda(monedaSeleccionada: Boolean): String {
    if (monedaSeleccionada == false) return " $"
    else return " €"
}

@Composable
private fun conversorDolar(
    monedaSeleccionada: Boolean,
    convertir: () -> Unit,
    cambiarMoneda: () -> Unit,
) {
    Button(
        onClick = {
            convertir()
            cambiarMoneda()
        },
        enabled = monedaSeleccionada
    ) { Text("$") }
}

@Composable
private fun conversorEuro(monedaSeleccionada: Boolean, convertir: () -> Unit, cambiarMoneda: () -> Unit) {
    Button(
        onClick = {
            convertir()
            cambiarMoneda()
        },
        enabled = !monedaSeleccionada
    ) { Text("€") }
}