package com.antpaniagua.t402internalstorage.ui

import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.antpaniagua.t402internalstorage.util.createDownloadFolder
import com.antpaniagua.t402internalstorage.util.createFile
import com.antpaniagua.t402internalstorage.util.createFolder
import com.antpaniagua.t402internalstorage.util.deleteFile
import com.antpaniagua.t402internalstorage.util.readFile
import com.antpaniagua.t402internalstorage.util.readFolder
import kotlinx.coroutines.launch


/**
 * Documentación:
 * https://developer.android.com/training/data-storage/app-specific
 */

@Composable
fun MainScreen(modifier: Modifier) {
    MainLayout(modifier)
}

@Composable
fun MainLayout(modifier: Modifier) {
    var filename: String by remember { mutableStateOf(fileNames.random()) }
    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        /** Espacio común*/
        createDownloadFolder("TEST")


        Spacer(Modifier.size(48.dp))
        TextAppTitle(title = "DAM. Almacenamiento específico")
        Spacer(Modifier.size(12.dp))
        TextSimple("La app cuenta con un almacenamiento propio encriptado")
        TextSimple("Trabajaremos con el")
        Spacer(Modifier.size(12.dp))
        ButtonCreateFile(
            filename,
            loremText.random(),
            onFileCreated = { filename = fileNames.random() })
        Spacer(Modifier.size(12.dp))
        ButtonPlayWithFolders()
        Spacer(Modifier.size(12.dp))
        ButtonDeleteFiles()
        Spacer(
            Modifier
                .size(12.dp)
                .weight(1f)
        )

    }
}

@Composable
fun ButtonPlayWithFolders() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Spacer(Modifier.size(16.dp))
        TextBoldSimple(
            "Genera un archivo, lee el contenido en Logcat y elimina otro",
            fontSize = 16f
        )
        Spacer(Modifier.size(16.dp))
        Button(onClick = {
            PlayWithFolders(context, filename = "archivo01.txt")
        }) {
            Text("Operar con archivos")
        }
        Spacer(Modifier.size(12.dp))
    }
}

fun PlayWithFolders(context: Context, filename:String) {
    createFolder(context, "Prueba 3")
    createFile(context, filename, "Contenido de prueba")
    Log.d("FILES", "Contenido: " + readFile(context, filename))
    //deleteFile(context, "profileInstalled")
    Log.d("FILES", readFolder(context = context).contentToString())
}

@Composable
fun ButtonDeleteFiles() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Spacer(Modifier.size(16.dp))
        TextBoldSimple(
            "Borra todos los archivos que se hayan creado con el primer botón",
            fontSize = 16f
        )
        Spacer(Modifier.size(16.dp))
        Button(onClick = {
            DeleteFiles(context)
        }) {
            Text("Borrar archivos")
        }
        Spacer(Modifier.size(12.dp))
    }
}

fun DeleteFiles(context: Context) {
    for (file in fileNames) {
        deleteFile(context, file)
    }
}

/**
 * ButtonCreateFile
 *
 * Genera un botón para crear un archivo con el contenido indicado. Al hacer clic elevamos
 * el estado de la variable onFileCreated para notificar al componente padre que se ha creado
 * y podemos generar otro archivo.
 *
 * La recomposición se encarga también automáticamente de cambiar el contenido del archivo.
 *
 * Esta función utiliza también un snackbar para notificar el resultado de la operación.
 */
@Composable
fun ButtonCreateFile(filename: String, content: String, onFileCreated: () -> Unit = {}) {
    val context = LocalContext.current
    val snackState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    fun showSnack(
        message: String,
        actionLabel: String? = null,
        duration: SnackbarDuration = SnackbarDuration.Short
    ) {
        scope.launch {
            snackState.showSnackbar(
                message = message,
                actionLabel = actionLabel,
                duration = duration
            )
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Spacer(Modifier.size(16.dp))
        TextBoldSimple("Crear fichero ${filename}", fontSize = 16f)
        Spacer(Modifier.size(16.dp))
        Button(onClick = {
            createFile(context, filename, content)
            showSnack("Archivo creado", "Ocultar")
            onFileCreated()
        }) {
            Text("Crear archivo")
        }

        //Creamos un espacio para mostrar el snackbar
        Box(modifier = Modifier.size(480.dp, 80.dp), Alignment.BottomCenter) {
            SnackbarHost(hostState = snackState)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(Modifier.fillMaxSize())
}
