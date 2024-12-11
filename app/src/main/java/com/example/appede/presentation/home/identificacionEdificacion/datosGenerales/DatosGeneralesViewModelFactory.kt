package com.example.appede.presentation.home.identificacionEdificacion.datosGenerales

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appede.data.repository.BuildingIdentificationRepository

class DatosGeneralesViewModelFactory(
    private val repository: BuildingIdentificationRepository,
    private val evaluationId: Int
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DatosGeneralesViewModel::class.java)) {
            return DatosGeneralesViewModel(repository, evaluationId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
