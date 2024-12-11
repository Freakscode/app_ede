package com.example.appede.presentation.home.identificacionEdificacion.datosGenerales

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appede.data.local.entity.BuildingIdentification
import com.example.appede.data.repository.BuildingIdentificationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DatosGeneralesViewModel(
    private val repository: BuildingIdentificationRepository,
    private val evaluationId: Int
) : ViewModel() {

    private val _state = MutableStateFlow<BuildingIdentification?>(null)
    val state: StateFlow<BuildingIdentification?> = _state

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            _state.value = repository.getBuildingIdentification(evaluationId)
        }
    }

    fun updateDatosGenerales(
        nombreEdificacion: String = _state.value?.nombreEdificacion ?: "",
        municipio: String = _state.value?.municipio ?: "",
        barrio: String = _state.value?.barrio ?: "",
        tipoPropiedad: String = _state.value?.tipoPropiedad ?: ""
    ) {
        _state.value = _state.value?.copy(
            nombreEdificacion = nombreEdificacion,
            municipio = municipio,
            barrio = barrio,
            tipoPropiedad = tipoPropiedad
        ) ?: BuildingIdentification(
            evaluationId = evaluationId,
            nombreEdificacion = nombreEdificacion,
            municipio = municipio,
            barrio = barrio,
            numVia = "",
            apVia = "",
            orientacionVia = "",
            numCruce = "",
            orientacionCruce = "",
            complemento = "",
            catastro = "",
            lat = "",
            lon = "",
            tipoPropiedad = tipoPropiedad
        )
    }

    fun saveDatosGenerales() {
        viewModelScope.launch {
            _state.value?.let { repository.saveBuildingIdentification(it) }
        }
    }
}
