package com.example.appede.data.repository

import com.example.appede.data.local.dao.DamageEvaluationDao
import com.example.appede.data.local.entity.DamageEvaluation

class DamageEvaluationRepository(private val dao: DamageEvaluationDao) {

    suspend fun getDamageEvaluation(evaluationId: Int): DamageEvaluation? {
        return dao.getByEvaluationId(evaluationId)
    }

    suspend fun saveDamageEvaluation(data: DamageEvaluation) {
        dao.insertOrUpdate(data)
    }

    suspend fun deleteDamageEvaluation(data: DamageEvaluation) {
        dao.delete(data)
    }
}
