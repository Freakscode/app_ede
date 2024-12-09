package com.example.appede.data.local.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appede.data.local.entity.Evaluaciones
import com.example.appede.data.local.entity.User
import com.example.appede.data.local.repository.appRepository
import kotlinx.coroutines.launch

class AppViewModel(private val repository: appRepository) : ViewModel() {

    // Métodos para la entidad User
    fun insertUser(user: User) = viewModelScope.launch {
        repository.insertUser(user)
    }

    fun deleteUser(user: User) = viewModelScope.launch {
        repository.deleteUser(user)
    }

    suspend fun isValidUser(username: String, password: String): Boolean {
        return repository.isValidUser(username, password)
    }

    // Métodos para la entidad Evaluaciones

    // LiveData para obtener todas las evaluaciones
    val allEvaluaciones: LiveData<List<Evaluaciones>> = repository.getAllEvaluaciones


    fun insertEvaluacion(evaluacion: Evaluaciones) = viewModelScope.launch {
        repository.insertEvaluacion(evaluacion)
    }

    fun updateEvaluacion(evaluacion: Evaluaciones) = viewModelScope.launch {
        repository.updateEvaluacion(evaluacion)
    }

    fun deleteEvaluacion(evaluacion: Evaluaciones) = viewModelScope.launch {
        repository.deleteEvaluacion(evaluacion)
    }
}
