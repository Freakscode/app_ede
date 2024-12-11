package com.example.appede.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appede.data.local.entity.ExternalRisks
import com.example.appede.data.repository.ExternalRisksRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ExternalRisksViewModel(
    private val repository: ExternalRisksRepository,
    private val evaluationId: Int
) : ViewModel() {

    private val _state = MutableStateFlow<ExternalRisks?>(null)
    val state: StateFlow<ExternalRisks?> = _state

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            _state.value = repository.getExternalRisks(evaluationId)
        }
    }

    fun updateExternalRisks(
        riesgoExterno: String,
        comprometeAcceso: String,
        comprometeEstabilidad: String
    ) {
        val newData = ExternalRisks(
            id = _state.value?.id ?: 0,
            evaluationId = evaluationId,
            riesgoExterno = riesgoExterno,
            comprometeAcceso = comprometeAcceso,
            comprometeEstabilidad = comprometeEstabilidad
        )

        viewModelScope.launch {
            repository.saveExternalRisks(newData)
            _state.value = newData
        }
    }
}
