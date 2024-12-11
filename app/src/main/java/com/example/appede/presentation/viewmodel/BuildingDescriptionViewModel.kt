package com.example.appede.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appede.data.local.entity.BuildingDescription
import com.example.appede.data.repository.BuildingDescriptionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BuildingDescriptionViewModel(
    private val repository: BuildingDescriptionRepository,
    private val evaluationId: Int
) : ViewModel() {

    private val _state = MutableStateFlow<BuildingDescription?>(null)
    val state: StateFlow<BuildingDescription?> = _state

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            _state.value = repository.getBuildingDescription(evaluationId)
        }
    }

    fun updateBuildingDescription(
        numPisos: Int,
        sotanos: Int,
        frente: Double,
        fondo: Double,
        numUnidadesResidenciales: Int,
        numUnidadesComerciales: Int,
        numUnidadesNoHab: Int,
        numOcupantes: Int,
        muertos: Int,
        heridos: Int,
        acceso: String,
        usoEdificacion: String,
        fechaDefinicionConstruccion: String
    ) {
        val newData = BuildingDescription(
            id = _state.value?.id ?: 0,
            evaluationId = evaluationId,
            numPisos = numPisos,
            sotanos = sotanos,
            frente = frente,
            fondo = fondo,
            numUnidadesResidenciales = numUnidadesResidenciales,
            numUnidadesComerciales = numUnidadesComerciales,
            numUnidadesNoHab = numUnidadesNoHab,
            numOcupantes = numOcupantes,
            muertos = muertos,
            heridos = heridos,
            acceso = acceso,
            usoEdificacion = usoEdificacion,
            fechaDefinicionConstruccion = fechaDefinicionConstruccion
        )

        viewModelScope.launch {
            repository.saveBuildingDescription(newData)
            _state.value = newData
        }
    }
}
