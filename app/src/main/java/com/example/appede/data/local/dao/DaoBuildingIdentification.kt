package com.example.appede.data.local.dao

import androidx.room.*
import com.example.appede.data.local.entity.BuildingIdentification

@Dao
interface BuildingIdentificationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(buildingIdentification: BuildingIdentification): Long

    @Query("SELECT * FROM building_identification WHERE evaluationId = :evaluationId")
    suspend fun getByEvaluationId(evaluationId: Int): BuildingIdentification?

    @Update
    suspend fun update(buildingIdentification: BuildingIdentification)

    @Delete
    suspend fun delete(buildingIdentification: BuildingIdentification)
}