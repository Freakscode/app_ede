package com.example.appede.presentation.home.identificacionEdificacion.identificacionCatastralLocalizacion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appede.data.repository.BuildingIdentificationRepository

class IdentificacionCatastralLocalizacionViewModelFactory(
    private val repository: BuildingIdentificationRepository,
    private val evaluationId: Int
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(IdentificacionCatastralLocalizacionViewModel::class.java)) {
            return IdentificacionCatastralLocalizacionViewModel(repository, evaluationId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
