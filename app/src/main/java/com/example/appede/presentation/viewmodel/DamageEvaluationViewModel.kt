package com.example.appede.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appede.data.local.entity.DamageEvaluation
import com.example.appede.data.repository.DamageEvaluationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DamageEvaluationViewModel(
    private val repository: DamageEvaluationRepository,
    private val evaluationId: Int
) : ViewModel() {

    private val _state = MutableStateFlow<DamageEvaluation?>(null)
    val state: StateFlow<DamageEvaluation?> = _state

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            _state.value = repository.getDamageEvaluation(evaluationId)
        }
    }

    fun updateDamageEvaluation(
        porcentajeAfectacion: String,
        severidadDanios: String,
        nivelDanio: String,
        habitabilidad: String,
        danios: String,
        evaluacionAdicional: String,
        recomendacionesMedidas: String,
        descripcionesGenerales: String
    ) {
        val newData = DamageEvaluation(
            id = _state.value?.id ?: 0,
            evaluationId = evaluationId,
            porcentajeAfectacion = porcentajeAfectacion,
            severidadDanios = severidadDanios,
            nivelDanio = nivelDanio,
            habitabilidad = habitabilidad,
            danios = danios,
            evaluacionAdicional = evaluacionAdicional,
            recomendacionesMedidas = recomendacionesMedidas,
            descripcionesGenerales = descripcionesGenerales
        )

        viewModelScope.launch {
            repository.saveDamageEvaluation(newData)
            _state.value = newData
        }
    }
}
