package com.mnunezg.listasdenombre

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Space
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mnunezg.listasdenombre.ui.theme.ListasDeNombreTheme

val names = mutableStateListOf<String>("Pepe", "María")
val extraNames = listOf<String>("Juan", "Ana")

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListasDeNombreTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainLayout(
                        modifier = Modifier.padding(
                            innerPadding
                        ), applicationContext
                    )
                }
            }
        }
    }// Fin del metodo onCreate
}// Fin de la clase

@Composable
fun MainLayout(modifier: Modifier = Modifier, applicationContext: Context) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextTitle("Mi primera aplicacion")

        Spacer(modifier = Modifier.height(32.dp))

        ButtonCambiarNombre(applicationContext)
        ButtonContarClics()
        Button(onClick = {
            names.add(extraNames[(0..extraNames.size - 1).random()])
        }) {
            Text("Añadir Nombre")
        }
        Spacer(modifier = Modifier.height(32.dp))

        TextListHello()
    }
}

@Composable
fun TextListHello() {
    LazyColumn {
        items(items = names) {
            //Clase anonima
                name ->
            Text(text = "Hola $name !!")
        }
    }
}

@Composable
fun ButtonCambiarNombre(applicationContext: Context) {
    Button(onClick = {
        cambiarNombre()
        Toast.makeText(applicationContext, "Nomrbe cambiado", Toast.LENGTH_LONG).show()
    }) {
        Text("Cambiar primer nombre")
    }
}

fun cambiarNombre() {
    Log.d("DAM1", "Lista: {$names}")
    if (names[0] == "Pepe") {
        names[0] = "Jose"
    } else {
        names[0] = "Pepe"
    }
    Log.d("DAM1", "Lista: {$names}")
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun ButtonContarClics() {
    var clicks = rememberSaveable { mutableStateOf(0) }
    Button(onClick = {
        clicks.value++
        Log.i("DAM2", clicks.toString())
    }) {
        Text("Haz Click. Total clicls: ${clicks.value}")
    }
}