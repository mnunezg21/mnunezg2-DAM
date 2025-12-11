package com.antpaniagua.t402internalstorage.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar() {
    TopAppBar (
        title= {Text(
            text = "Almacenamiento específico",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Start,
        )}
    )
}
