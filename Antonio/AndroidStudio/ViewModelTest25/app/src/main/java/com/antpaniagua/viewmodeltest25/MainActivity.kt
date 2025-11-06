package com.antpaniagua.viewmodeltest25

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.antpaniagua.viewmodeltest25.ui.CitiesApp
import com.antpaniagua.viewmodeltest25.ui.DiceApp
import com.antpaniagua.viewmodeltest25.ui.theme.ViewModelTest25Theme


/** Viewmodel Test 25
 *
 * Antonio Paniagua
 *
 * Septiembre 2025
 *
 * Esta app contiene dos ejemplos de uso de viewmodel. El primero, basado en un tutorial de Android
 * Developer se denomina DiceApp. El segundo CitiesApp. Comenta o descomenta las líneas de onCreate
 * para probar uno u otro.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ViewModelTest25Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    MainApp(modifier = Modifier.padding(innerPadding))

                }
                }
            }
        }
    }

@Composable
fun MainApp(modifier: Modifier) {
    var destino by rememberSaveable { mutableStateOf("") }


    Column(modifier = modifier.fillMaxWidth().padding(vertical = 48.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Dos ejemplos de uso de Viewmodel", fontWeight = FontWeight.Bold)
        Text("Tirada de dados", Modifier.clickable { destino = "dados" })
        Text("Lista de ciudades", Modifier.clickable { destino = "ciudades" })
        when (destino) {
            "dados" -> DiceApp(modifier)
            "ciudades" -> CitiesApp(modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DiceAppPreview() {
    ViewModelTest25Theme {
        DiceApp(Modifier.fillMaxSize())
    }
}


@Preview(showBackground = true)
@Composable
fun CitiesAppPreview() {
    ViewModelTest25Theme {
        CitiesApp(Modifier.fillMaxSize())
    }
}