package com.antpaniagua.viewmodeltest25.viewmodels

import androidx.lifecycle.ViewModel
import com.antpaniagua.viewmodeltest25.data.Datasource
import com.antpaniagua.viewmodeltest25.model.City
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CitiesViewModel : ViewModel() {
    //_uiState es una variable interna, privada, mutable, usando Flow en este caso.
    // Mostramos un objeto entero (DiceUIState)
    private val _cities = MutableStateFlow(Datasource.cityList)

    //exponemos el elemento anterior mediante uiState, en este caso sin que sea privado
    //asstateflow hace el el flujo de estado mutable sea de sólo lectura
    val cities: StateFlow<List<City>> = _cities.asStateFlow()

    // Implementamos nuestra lógica de negocio. Creamos ciudad y la eliminamos
    fun addCity(name: String) {
        val listaActual = _cities.value.toMutableList()
        listaActual.add(generateRandomCity(listaActual))
        _cities.value = listaActual

    }

    fun removeCity(id: Int) {
        val listaACtual = _cities.value.toMutableList()
        listaACtual.removeAt(id)
        _cities.value = listaACtual
    }

    //Función auxiliar que genera una ciudad aleatoria
    fun generateRandomCity(citiesList: List<City>): City {
        val id = citiesList.size + 1 //Sólo funciona bien si no se ha borrado nada. Requiere refactorizar
        val name = Datasource.cityList.random().cityName
        return City(id, name)

    }

}

