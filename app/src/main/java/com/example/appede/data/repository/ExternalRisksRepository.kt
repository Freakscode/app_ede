package com.example.appede.data.repository

import com.example.appede.data.local.dao.ExternalRisksDao
import com.example.appede.data.local.entity.ExternalRisks

class ExternalRisksRepository(private val dao: ExternalRisksDao) {

    suspend fun getExternalRisks(evaluationId: Int): ExternalRisks? {
        return dao.getByEvaluationId(evaluationId)
    }

    suspend fun saveExternalRisks(data: ExternalRisks) {
        dao.insertOrUpdate(data)
    }

    suspend fun deleteExternalRisks(data: ExternalRisks) {
        dao.delete(data)
    }
}
