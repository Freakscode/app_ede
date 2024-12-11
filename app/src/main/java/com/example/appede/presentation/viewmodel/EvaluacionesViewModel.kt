package com.example.appede.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appede.data.local.entity.Evaluaciones
import com.example.appede.data.repository.EvaluacionesRepository
import kotlinx.coroutines.launch

class EvaluacionesViewModel(private val repository: EvaluacionesRepository) : ViewModel() {

    private val _evaluaciones = MutableLiveData<List<Evaluaciones>>()
    val evaluaciones: LiveData<List<Evaluaciones>> get() = _evaluaciones

    init {
        fetchEvaluaciones()
    }

    private fun fetchEvaluaciones() {
        viewModelScope.launch {
            val result = repository.getAllEvaluaciones()
            _evaluaciones.postValue(result.value)
        }
    }

    fun addEvaluacion(evaluacion: Evaluaciones) {
        viewModelScope.launch {
            repository.insertEvaluacion(evaluacion)
            fetchEvaluaciones() // Refrescar la lista después de agregar
        }
    }

    fun removeEvaluacion(evaluacion: Evaluaciones) {
        viewModelScope.launch {
            repository.deleteEvaluacion(evaluacion)
            fetchEvaluaciones() // Refrescar la lista después de eliminar
        }
    }
}
