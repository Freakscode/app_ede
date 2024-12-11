package com.example.appede.presentation.viewmodel

import com.example.appede.data.local.entity.FullEvaluacion
import kotlinx.coroutines.flow.StateFlow

interface FullEvaluacionViewModelInterface {
    val state: StateFlow<List<FullEvaluacion>>
    fun refreshEvaluaciones(usuarioId: Int)
}
