package com.example.appede.presentation.home.identificacionEdificacion.descripcionGeneral

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appede.data.local.entity.BuildingIdentification
import com.example.appede.data.repository.BuildingIdentificationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DescripcionGeneralViewModel(
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

    fun updateDescripcionGeneral(
        numVia: String = _state.value?.numVia ?: "",
        apVia: String = _state.value?.apVia ?: "",
        orientacionVia: String = _state.value?.orientacionVia ?: "",
        numCruce: String = _state.value?.numCruce ?: "",
        orientacionCruce: String = _state.value?.orientacionCruce ?: "",
        complemento: String = _state.value?.complemento ?: ""
    ) {
        _state.value = _state.value?.copy(
            numVia = numVia,
            apVia = apVia,
            orientacionVia = orientacionVia,
            numCruce = numCruce,
            orientacionCruce = orientacionCruce,
            complemento = complemento
        )
    }

    fun saveDescripcionGeneral() {
        viewModelScope.launch {
            _state.value?.let { repository.saveBuildingIdentification(it) }
        }
    }
}
