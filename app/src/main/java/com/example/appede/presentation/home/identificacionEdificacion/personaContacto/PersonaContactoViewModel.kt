package com.example.appede.presentation.home.identificacionEdificacion.personaContacto

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appede.data.local.entity.Evaluaciones
import com.example.appede.data.repository.EvaluacionesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PersonaContactoViewModel(
    private val repository: EvaluacionesRepository,
    private val evaluationId: Int
) : ViewModel() {

    private val _state = MutableStateFlow<Evaluaciones?>(null)
    val state: StateFlow<Evaluaciones?> = _state

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            _state.value = repository.getEvaluacionById(evaluationId)
        }
    }

    fun updatePersonaContacto(
        nombrePersonasCont: String = _state.value?.nombrePersonasCont ?: "",
        emailPersonaCont: String = _state.value?.emailPersonaCont ?: "",
        celPersonaCont: String = _state.value?.celPersonaCont ?: "",
        responsablePersonaCont: String = _state.value?.responsablePersonaCont ?: ""
    ) {
        val current = _state.value
        if (current != null) {
            _state.value = current.copy(
                nombrePersonasCont = nombrePersonasCont,
                emailPersonaCont = emailPersonaCont,
                celPersonaCont = celPersonaCont,
                responsablePersonaCont = responsablePersonaCont
            )
        }
    }

    fun savePersonaContacto() {
        viewModelScope.launch {
            _state.value?.let { evaluacion ->
                repository.updateEvaluacion(evaluacion)
            }
        }
    }
}
