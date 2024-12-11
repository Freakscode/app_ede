package com.example.appede.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appede.data.local.entity.StructuralSystem
import com.example.appede.data.repository.StructuralSystemRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class StructuralSystemViewModel(
    private val repository: StructuralSystemRepository,
    private val evaluationId: Int
) : ViewModel() {

    private val _state = MutableStateFlow<StructuralSystem?>(null)
    val state: StateFlow<StructuralSystem?> = _state

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            _state.value = repository.getStructuralSystem(evaluationId)
        }
    }

    fun updateStructuralSystem(
        sistemaEstructural: String,
        material: String,
        sistemaEntrepiso: String,
        materialEntrepiso: String,
        sistemaSoporte: String,
        revestimiento: String,
        murosDivisores: String,
        fachadas: String,
        escaleras: String,
        nivelDiseno: String,
        calidadDiseno: String,
        estadoEdificacion: String
    ) {
        val newData = StructuralSystem(
            id = _state.value?.id ?: 0,
            evaluationId = evaluationId,
            sistemaEstructural = sistemaEstructural,
            material = material,
            sistemaEntrepiso = sistemaEntrepiso,
            materialEntrepiso = materialEntrepiso,
            sistemaSoporte = sistemaSoporte,
            revestimiento = revestimiento,
            murosDivisores = murosDivisores,
            fachadas = fachadas,
            escaleras = escaleras,
            nivelDiseno = nivelDiseno,
            calidadDiseno = calidadDiseno,
            estadoEdificacion = estadoEdificacion
        )

        viewModelScope.launch {
            repository.saveStructuralSystem(newData)
            _state.value = newData
        }
    }
}
