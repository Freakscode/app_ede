package com.example.appede.presentation.home.logged.buildingIdentification

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appede.data.repository.BuildingIdentificationRepository
import com.example.appede.presentation.viewmodel.BuildingIdentificationViewModel

class BuildingIdentificationViewModelFactory(
    private val repository: BuildingIdentificationRepository,
    private val evaluationId: Int
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BuildingIdentificationViewModel::class.java)) {
            return BuildingIdentificationViewModel(repository, evaluationId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}