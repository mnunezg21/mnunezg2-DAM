package com.antpaniagua.androides

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.antpaniagua.androides.ui.theme.AndroidesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AndroideScreen()
                }
            }
        }
    }
}

@Composable
fun AndroideScreen(modifier: Modifier = Modifier) {
    var checkRed: Boolean by remember { mutableStateOf(false) }
    var checkBlue: Boolean by remember { mutableStateOf(false) }
    var checkGreen: Boolean by remember { mutableStateOf(false) }
    var imgResource: Int by remember { mutableStateOf(R.drawable.androidretro) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(12.dp)
    ) {
        Text(
            text = "Androides de colores",
            fontSize = 32.sp,
        )
        Row() {
            BloqueAndroides()
        }

        Spacer(Modifier.size(24.dp))

        Image(
            painterResource(id = imgResource),
            contentDescription = "ImageAndroidRetro4",
            Modifier.size(200.dp)
        )
        SwitchColores("Rojo", checkRed, onChangeColor = {
            checkRed = !checkRed
            if (checkRed) {
                checkGreen = false
                checkBlue = false
                imgResource = R.drawable.androidred
            } else imgResource = R.drawable.androidretro
        })
        SwitchColores("Azul", checkBlue, onChangeColor = { nuevoVal ->
            checkBlue = nuevoVal
            if (checkBlue) {
                checkGreen = false
                checkRed = false
                imgResource = R.drawable.androidblue
            } else imgResource = R.drawable.androidretro
        })
        SwitchColores("Verde", checkGreen, onChangeColor = {
            checkGreen = it
            if (checkGreen) {
                checkRed = false
                checkBlue = false
                imgResource = R.drawable.androidgreen
            } else imgResource = R.drawable.androidretro
        })
    }
}

@Composable
fun SwitchColores(color: String, state: Boolean, onChangeColor: (Boolean) -> Unit) {

    Row {
        Text(text = color, fontSize = 18.sp)
        Switch(checked = state, onCheckedChange = onChangeColor)
    }
}

@Composable
fun BloqueAndroides() {
    for (i in 1..4) {
        Image(
            painter = painterResource(id = R.drawable.androidretro),
            contentDescription = "ImageAndroidRetro1",
            Modifier.size(100.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    AndroidesTheme {
        AndroideScreen()
    }
}