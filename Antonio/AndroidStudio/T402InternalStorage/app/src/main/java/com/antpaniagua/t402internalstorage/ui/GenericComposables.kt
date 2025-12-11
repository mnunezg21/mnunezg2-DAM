package com.antpaniagua.t402internalstorage.ui

import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * GenericComposables
 * Una pequeña biblioteca de funciones de uso común en varias aplicaciones
 */
@Composable
fun TextAppTitle(title:String) {
    Text(
        text=title,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.titleLarge,
        modifier = Modifier.height(64.dp),
        fontSize = 24.sp
    )
}

@Composable
fun TextBoldSimple(message: String, fontSize: Float) {
    Text(
        text = message,
        textAlign = TextAlign.Center,
        fontSize = fontSize.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun TextSimple(message: String) {
    Text(
        text = message,
        fontSize = 14.sp,
    )
}