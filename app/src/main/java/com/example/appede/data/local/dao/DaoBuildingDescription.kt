package com.example.appede.data.local.dao

import androidx.room.*
import com.example.appede.data.local.entity.BuildingDescription

@Dao
interface BuildingDescriptionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(buildingDescription: BuildingDescription): Long

    @Query("SELECT * FROM building_description WHERE evaluationId = :evaluationId LIMIT 1")
    suspend fun getByEvaluationId(evaluationId: Int): BuildingDescription?

    @Delete
    suspend fun delete(buildingDescription: BuildingDescription)
}
