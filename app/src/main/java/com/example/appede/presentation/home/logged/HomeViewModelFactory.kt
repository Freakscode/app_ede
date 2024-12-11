package com.example.appede.presentation.home.logged

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appede.data.repository.EvaluacionesRepository

class HomeViewModelFactory(private val repository: EvaluacionesRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}