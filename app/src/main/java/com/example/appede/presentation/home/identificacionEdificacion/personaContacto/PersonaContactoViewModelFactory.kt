package com.example.appede.presentation.home.identificacionEdificacion.personaContacto

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appede.data.repository.EvaluacionesRepository

class PersonaContactoViewModelFactory(
    private val repository: EvaluacionesRepository,
    private val evaluationId: Int
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PersonaContactoViewModel::class.java)) {
            return PersonaContactoViewModel(repository, evaluationId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
