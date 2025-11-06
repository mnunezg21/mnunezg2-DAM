package com.antpaniagua.viewmodeltest25.ui

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Place
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.antpaniagua.viewmodeltest25.model.City
import com.antpaniagua.viewmodeltest25.viewmodels.CitiesViewModel

@Composable
fun CitiesApp(modifier: Modifier) {

    /** = viewModel es una forma de llamar a los viewmodels dentro de las funciones.
     * requiere añadir esta línea a libs.versions
     * lifecycleRuntimeKtx = "2.9.4"
     * androidx-lifecycle-viewmodel-compose = { module = "androidx.lifecycle:lifecycle-viewmodel-compose", version.ref = "lifecycleRuntimeKtx" }
     *
     * y en gradle
     * implementation(libs.androidx.lifecycle.viewmodel.compose)
     */

    val citiesViewModel: CitiesViewModel = viewModel()
    val cities by citiesViewModel.cities.collectAsState()

    Column(modifier = modifier.padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Prueba de ViewModel",
            fontSize = 24.sp,
        )

        Button(onClick = { citiesViewModel.addCity("Plasencia") }) {
            Text("Añadir ciudad")
        }
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {
            itemsIndexed(cities)
            { index, item ->
                Card(
                    elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                    border = BorderStroke(1.dp, Color.LightGray),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                ) {
                    //Cada elemento cuenta con un dato de elemento, un índice y una operación derivada de una elevación de estado
                    ListItem(item, index, onBorrado = { id: Int -> citiesViewModel.removeCity(id) })
                }
            }
        }
    }
}


@Composable
fun ListItem(city: City, index: Int, onBorrado: (Int) -> Unit) {
    // Biblioteca de iconos
    // https://developer.android.com/reference/kotlin/androidx/compose/material/icons/package-summary
    var expanded by remember { mutableStateOf(false) }

    Column(Modifier.padding(4.dp)) {
        Row(Modifier.height(height = (if (expanded) 128.dp else 64.dp))) {
            Icon(
                imageVector = Icons.TwoTone.Place,
                contentDescription = ("Lugar"),
                tint = Color(44, 44, 200, 255),
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(size = 64.dp)
                    .clickable {
                        expanded = !expanded
                        Log.d("CLICKED", "Click on $city")
                    },
            )
            Text(
                text = city.cityName,
                Modifier
                    .padding(6.dp, 12.dp)
                    .align(Alignment.CenterVertically)
            )
            /* La alineación heredada que hacemos desde el botón sólo funciona si está dentro de un box,
            no desde un Row o Column
             */
            Box(
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Button(
                    onClick = { onBorrado(index) },
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
                {
                    Text("Borrrar")
                }
            }
        }

        if (expanded) {
            Text("Bla bla bla, bla bla, blablabla")
        }
    }
}