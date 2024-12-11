package com.example.appede.data.repository

import com.example.appede.data.local.dao.StructuralSystemDao
import com.example.appede.data.local.entity.StructuralSystem

class StructuralSystemRepository(private val dao: StructuralSystemDao) {

    suspend fun getStructuralSystem(evaluationId: Int): StructuralSystem? {
        return dao.getByEvaluationId(evaluationId)
    }

    suspend fun saveStructuralSystem(data: StructuralSystem) {
        dao.insertOrUpdate(data)
    }

    suspend fun deleteStructuralSystem(data: StructuralSystem) {
        dao.delete(data)
    }
}
