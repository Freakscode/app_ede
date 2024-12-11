package com.example.appede.data.repository

import android.util.Log
import com.example.appede.data.local.dao.DaoUser
import com.example.appede.data.local.entity.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository(private val daoUser: DaoUser) {
    private val TAG = "UserRepository"


    suspend fun getUserById(id: Int): User? {
        return daoUser.getUserById(id)
    }

    suspend fun insertUser(user: User): Long {
        return daoUser.insert(user)
    }

    suspend fun isValidUser(personaID: Int, password: String): Boolean {
        Log.d(TAG, "Verificando usuario con personaID: $personaID")
        val result = daoUser.isValidUser(personaID, password)
        Log.d(TAG, "Resultado de verificación: $result")
        return result
    }

    suspend fun getUserByPersonaId(personaId: Int): User? {
        return daoUser.getUserByPersonaId(personaId)
    }

}