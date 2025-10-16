package com.mnunezg.listasdenombre

import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

@Composable
fun TextTitle(title:String) {
    Text(text = title,
        style = typography.titleLarge,
        textAlign = TextAlign.Center,
        color = Color.Blue)
}