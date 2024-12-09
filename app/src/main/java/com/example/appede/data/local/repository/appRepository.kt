package com.example.appede.data.local.repository

import androidx.lifecycle.LiveData
import com.example.appede.data.local.dao.DaoEvaluaciones
import com.example.appede.data.local.dao.DaoUser
import com.example.appede.data.local.entity.Evaluaciones
import com.example.appede.data.local.entity.User
import kotlinx.coroutines.flow.Flow

class appRepository(private val userDao: DaoUser, private val evaluacionesDao: DaoEvaluaciones ) {

    // Métodos para la entidad User
    suspend fun insertUser(user: User) {
        userDao.insert(user)
    }

    suspend fun isValidUser(username: String, password: String): Boolean {
        return userDao.isValidUser(username, password)
    }

    suspend fun deleteUser(user: User) {
        userDao.getAllUsers()
    }

    // Métodos para la entidad Evaluaciones

    suspend fun insertEvaluacion(evaluacion: Evaluaciones) {
        evaluacionesDao.insertEvaluacion(evaluacion)
    }

    suspend fun updateEvaluacion(evaluacion: Evaluaciones) {
        evaluacionesDao.updateEvaluacion(evaluacion)
    }

    suspend fun deleteEvaluacion(evaluacion: Evaluaciones) {
        evaluacionesDao.deleteEvaluacion(evaluacion)
    }

    val getAllEvaluaciones: LiveData<List<Evaluaciones>> = evaluacionesDao.getAllEvaluaciones()
}