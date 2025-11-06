package com.antpaniagua.viewmodeltest25.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.random.Random
//https://developer.android.com/topic/libraries/architecture/viewmodel?hl=es-419#implement-viewmodel
data class DiceUiState(
    val dado1: Int? = null,
    val dado2: Int? = null,
    val totalTiradas: Int = 0,
)

class DiceRollViewModel : ViewModel() {

    //_uiState es una variable interna, privada, mutable, usando Flow en este caso.
    // Mostramos un objeto entero (DiceUIState)
    private val _uiState = MutableStateFlow(DiceUiState())
    //exponemos el elemento anterior mediante uiState
    val uiState: StateFlow<DiceUiState> = _uiState.asStateFlow()



    // Implementamos nuestra lógica de negocio. En este caso una función que tira los dados
    fun rollDice() {
        _uiState.update { currentState ->
            currentState.copy(
                dado1 = Random.nextInt(from = 1, until = 7),
                dado2 = Random.nextInt(from = 1, until = 7),
                totalTiradas = currentState.totalTiradas + 1,
            )
        }
        Log.d("DADOS", "Se han lanzado los datos: ${_uiState.value.dado1} | ${_uiState.value.dado2}")
    }

    //Otro método, que simula que eliminamos una tirada
    fun removeRollDice() {
        _uiState.update { estado ->
            estado.copy(totalTiradas = estado.totalTiradas - 1)
        }
    }

}
