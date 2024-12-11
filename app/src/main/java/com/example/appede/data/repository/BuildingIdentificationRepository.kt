package com.example.appede.data.repository

import com.example.appede.data.local.dao.BuildingIdentificationDao
import com.example.appede.data.local.entity.BuildingIdentification

class BuildingIdentificationRepository(private val dao: BuildingIdentificationDao) {

    suspend fun getBuildingIdentification(evaluationId: Int): BuildingIdentification? {
        return dao.getByEvaluationId(evaluationId)
    }

    suspend fun saveBuildingIdentification(data: BuildingIdentification) {
        dao.insert(data)
    }

    suspend fun deleteBuildingIdentification(data: BuildingIdentification) {
        dao.delete(data)
    }
}
