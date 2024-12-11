// AddEvaluacionViewModelFactory.kt
package com.example.appede.presentation.home.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appede.data.repository.EvaluacionesRepository

class AddEvaluacionViewModelFactory(
    private val repository: EvaluacionesRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddEvaluacionViewModel::class.java)) {
            return AddEvaluacionViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
