package com.mnunezg.adivinarnmero

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.mnunezg.adivinarnmero.ui.theme.AdivinarNúmeroTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdivinarNúmeroTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "DAM2",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Log.d("Dam2","Hola a todos!!")
    //MODIFICAR COLUMNAS Y BOTONES

    Column(modifier = Modifier.fillMaxSize().padding().background(Color.Gray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Button(onClick = {Log.d("Click","Click")}) {
            Text(
                text="Haz clic"
            )
        }
        Button(onClick = {Log.d("Click",generarAleatorios(10))}){
            Text(
                text="Generar Aleatorios"
            )
        }
    }
}

fun generarAleatorios(cantidad :Int) :String {
    var numerosAleatorios = mutableListOf(0)
    for (i in 0..cantidad){
        numerosAleatorios.add(Random.nextInt(10))
    }
    return numerosAleatorios.toString()+" ";
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AdivinarNúmeroTheme {
        Greeting("Android")
    }
}