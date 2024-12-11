package com.example.appede.presentation.home.logged

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appede.data.local.entity.Evaluaciones
import com.example.appede.data.repository.EvaluacionesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: EvaluacionesRepository
) : ViewModel() {

    private val _evaluaciones = MutableStateFlow<List<Evaluaciones>>(emptyList())
    val evaluaciones: StateFlow<List<Evaluaciones>> = _evaluaciones

    private val _isDataIngestion = MutableStateFlow(false)
    val isDataIngestion: StateFlow<Boolean> = _isDataIngestion

    fun fetchLastFiveEvals(usuarioId: Int) {
        viewModelScope.launch {
            try {
                val lista = repository.getLastFiveEvaluaciones(usuarioId)
                _evaluaciones.value = lista
            } catch (e: Exception){

            } finally {

            }
        }
    }
}