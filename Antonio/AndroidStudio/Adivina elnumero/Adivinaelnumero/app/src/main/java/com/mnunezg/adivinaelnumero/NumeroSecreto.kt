package com.mnunezg.adivinaelnumero

import android.content.Context
import android.widget.Toast
import kotlin.random.Random

// Mario Núñez García
fun numeroAleatorio(): Int {
    val numeroAleatorio: Int = Random.nextInt(1, 10)
    return numeroAleatorio
}

fun comprobarResultado(context: Context, numero: Int, random: Int):Boolean {
    var resultado: Boolean
    if (numero==random){
        Toast.makeText(
            context,
            "Número correcto",
            Toast.LENGTH_SHORT
        ).show()
        return true
    } else {
        Toast.makeText(
            context,
            "Número no acertado",
            Toast.LENGTH_SHORT
        ).show()
        return false
    }



}