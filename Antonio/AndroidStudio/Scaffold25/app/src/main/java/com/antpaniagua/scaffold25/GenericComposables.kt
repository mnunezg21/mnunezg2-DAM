package com.antpaniagua.scaffold25

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


/** Biblioteca con algunas funciones composables extra **/

@Composable
fun TextHead1(text: String) {
    Text(
        text = text, fontSize = 24.sp, lineHeight = 48.sp,  modifier = Modifier.padding(6.dp)
    )
}

@Composable
fun TextParagraph(text: String) {
    Text(
        text = text, fontSize = 14.sp, lineHeight = 22.sp, modifier = Modifier.padding(6.dp)
    )
}