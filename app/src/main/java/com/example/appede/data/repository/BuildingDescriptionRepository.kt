package com.example.appede.data.repository

import com.example.appede.data.local.dao.BuildingDescriptionDao
import com.example.appede.data.local.entity.BuildingDescription

class BuildingDescriptionRepository(private val dao: BuildingDescriptionDao) {

    suspend fun getBuildingDescription(evaluationId: Int): BuildingDescription? {
        return dao.getByEvaluationId(evaluationId)
    }

    suspend fun saveBuildingDescription(data: BuildingDescription) {
        dao.insertOrUpdate(data)
    }

    suspend fun deleteBuildingDescription(data: BuildingDescription) {
        dao.delete(data)
    }
}
