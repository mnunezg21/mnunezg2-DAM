package com.mnunezg.adivinaelnumero

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mnunezg.adivinaelnumero.ui.theme.AdivinaElnúmeroTheme
import kotlin.random.Random

// Mario Núñez García
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdivinaElnúmeroTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AdivinarNumero(name = "AdivinarNúmero", modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun AdivinarNumero(name: String, modifier: Modifier = Modifier) {
    var ganado by remember { mutableStateOf(false) }
    val context = LocalContext.current
    var numeroIntroducido by remember { mutableStateOf("") }
    var random by remember { mutableStateOf(numeroAleatorio()) }

    Column(
        modifier.fillMaxSize().padding(12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Adivina el número")
        Text(text = "Introduce un número entre el 1 y el 10")

        TextField(
            value = numeroIntroducido,
            label = { Text("Número") },
            onValueChange = { numeroIntroducido = it },
        )

        if (!ganado) {
            Button(onClick = {
                try {
                    val numero = numeroIntroducido.toInt()

                    if (numero !in 1..10) {
                        Toast.makeText(
                            context,
                            "Introduce un número entre 1 y 10",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        val acertado = comprobarResultado(context, numero, random)
                        if (acertado) {
                            random = numeroAleatorio()
                            numeroIntroducido = ""
                            ganado = true
                        }
                    }
                } catch (e: NumberFormatException) {
                    Toast.makeText(
                        context,
                        "Introduce un número válido",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }) {
                Text("Comprobar")
            }
        } else {
            Button(onClick = {
                random = numeroAleatorio()
                numeroIntroducido = ""
                ganado = false
            }) {
                Text("Nuevo juego")
            }
        }
    }
}



