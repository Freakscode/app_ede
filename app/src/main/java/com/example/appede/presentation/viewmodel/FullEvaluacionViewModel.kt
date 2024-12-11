package com.example.appede.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appede.data.local.entity.FullEvaluacion
import com.example.appede.data.repository.EvaluacionesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FullEvaluacionViewModel(
    private val repository: EvaluacionesRepository,
    private val usuarioId: Int
) : ViewModel(), FullEvaluacionViewModelInterface {

    private val _state = MutableStateFlow<List<FullEvaluacion>>(emptyList())
    override val state: StateFlow<List<FullEvaluacion>> = _state

    init {
        refreshEvaluaciones(usuarioId)
    }

    override fun refreshEvaluaciones(usuarioId: Int) {
        viewModelScope.launch {
            val list = repository.getLastFiveFullEvaluaciones(usuarioId)
            _state.value = list
        }
    }
}
