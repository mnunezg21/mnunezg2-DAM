package com.antpaniagua.scaffold25

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.antpaniagua.scaffold25.ui.theme.Scaffold25Theme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Scaffold 2025
 * Septiembre 2025
 *
 * Uso del Scaffold y Snackbar en Android Studio
 *
 */

private const val TAG: String = "Estructura"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold25Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ScaffoldApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ScaffoldApp(modifier: Modifier = Modifier) {
    // Preparamos el snackbar con las dos líneas siguientes
    // Fuente: https://developer.android.com/develop/ui/compose/components/snackbar
    // El snackbar se genera como una parte del Scaffold, por lo que hay que declararlo en este nivel
    // y pasarlo como parámetro
    val scope = rememberCoroutineScope()
    /** Aquí no se puede usar by porque by devuelve el valor de un objeto de tipo State<T> mientras
     * que aquí SnackBarHostState() devuelve directamente una instancia de SnackbarHostState */
    val sbarHostState = remember { SnackbarHostState() }

    Scaffold(
        topBar = { MainTopBar() },
        bottomBar = { MainBottomBar(scope, sbarHostState) },
        floatingActionButton = { MainFAB() },
        snackbarHost = { SnackbarHost(hostState = sbarHostState) }

    )
//con innerPadding podemos pasar parámetros al interior del Scaffold
    { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).fillMaxSize(),
            verticalArrangement = Arrangement.Top,
        )
        {
            MainContent()
        }
    }
// ModalNavigationDrawer(drawerContent = { MainDrawer() }) { } //Revisar con calma
}

@Composable
fun MainContent() {
    TextHead1("Aplicación con Scaffold")
    TextParagraph("Prueba de concepto de uso de Scaffold y otros recursos de Material3.")
    TextParagraph("La mayoría de los elementos el interface despliegan información en el Logcat.")
    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
        Button(
            onClick = { Log.d(TAG, "Botón Entendido pulsado") }) { Text("Entendido") }
    }
}

@Composable
fun MainDrawer() {
    Column(Modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceBetween) {
        Spacer(Modifier.size(24.dp))
        Text("Panel lateral")
        Text("Con varias cosas")
    }
}

// ExperimentalMaterial3Api, aspectos qeu están todavía en desarrollo. Se anotan as
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar() {
    TopAppBar(
        colors = topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        modifier = Modifier.fillMaxWidth(),
        title = {
            Row(modifier = Modifier.fillMaxWidth()) {
                Icon(
                    painter = painterResource(R.drawable.ic_action_apartament),
                    "",
                    Modifier.padding(6.dp, 0.dp)
                )
                Text("Scaffold Test")
                Spacer(Modifier.weight(1f)) //El peso 1f hace que crezca empujando el icono hasta la derecha
                Icon(imageVector = Icons.Filled.MoreVert, "", Modifier.padding(6.dp, 0.dp))
            }
        })
}

/** MainBottomBar emplea corrutinas y estados para lanzar el composable snackbar
 * dentro de la aplicación */
@Composable
fun MainBottomBar(scope: CoroutineScope, sbarHostState: SnackbarHostState) {
    BottomAppBar(
        actions = {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(6.dp, 0.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(onClick = {
                    //scope.launch se emplea para lanzar una corrutina, en este caso para mostrar un snackbar
                    scope.launch {
                        sbarHostState.showSnackbar("Pulsado botón de usuario")
                    }
                }) {
                    Icon(
                        Icons.Filled.AccountCircle, "Detalle de usuario",
                    )
                }

                IconButton(onClick = {
                    Log.d(TAG, "Enviando correo electrónico")
                }) {
                    Icon(Icons.Filled.Email, "Enviar correo")
                }

                AssistChipExample() //Chip es otro tipo de elemento

                Button(onClick = {
                    Log.d(TAG, "Pulsado el botón Acción 3")
                }) {
                    Text("Acción 3")
                }

                Text("Acción 4", Modifier.clickable {
                    Log.d(TAG, "Pulsado el texto Acción 4")
                })
            }
        },
        floatingActionButton = {
            // Podemos usar este espacio para añadir botones flotantes a la barra inferior
        }
    )
}

@Composable
fun MainFAB() {
    FloatingActionButton(
        onClick = { Log.d(TAG, "Botón flotante pulsado") },
        containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
    ) {
        Icon(Icons.Filled.Home, "Botón flotante")
    }
}

@Composable
fun AssistChipExample() {
    AssistChip(
        onClick = { Log.d("Assist chip", "Pulsado en el Chip") },
        label = { Text("Chip") },
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_action_biotech),
                contentDescription = "Icóno básico",
                Modifier.size(AssistChipDefaults.IconSize)
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Scaffold25Theme {
        ScaffoldApp()
    }
}
