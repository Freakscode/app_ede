package com.example.appede.presentation.home.identificacionEdificacion.identificacionCatastralLocalizacion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appede.data.local.entity.BuildingIdentification
import com.example.appede.data.repository.BuildingIdentificationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class IdentificacionCatastralLocalizacionViewModel(
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

    fun updateCatastralLocalizacion(
        catastro: String = _state.value?.catastro ?: "",
        lat: String = _state.value?.lat ?: "",
        lon: String = _state.value?.lon ?: ""
    ) {
        _state.value = _state.value?.copy(
            catastro = catastro,
            lat = lat,
            lon = lon
        )
    }

    fun saveCatastralLocalizacion() {
        viewModelScope.launch {
            _state.value?.let { repository.saveBuildingIdentification(it) }
        }
    }
}
