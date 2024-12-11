package com.example.appede.presentation.home.identificacionEdificacion.descripcionGeneral

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appede.data.repository.BuildingIdentificationRepository

class DescripcionGeneralViewModelFactory(
    private val repository: BuildingIdentificationRepository,
    private val evaluationId: Int
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DescripcionGeneralViewModel::class.java)) {
            return DescripcionGeneralViewModel(repository, evaluationId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
