package com.example.appede.presentation.home.identificacionEdificacion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appede.data.repository.BuildingIdentificationRepository

class IdentificacionEdificacionViewModelFactory(
    private val repository: BuildingIdentificationRepository,
    private val evaluationId: Int
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(IdentificacionEdificacionViewModel::class.java)) {
            return IdentificacionEdificacionViewModel(repository, evaluationId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
