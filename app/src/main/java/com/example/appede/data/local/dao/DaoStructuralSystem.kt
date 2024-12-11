package com.example.appede.data.local.dao

import androidx.room.*
import com.example.appede.data.local.entity.StructuralSystem

@Dao
interface StructuralSystemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(structuralSystem: StructuralSystem): Long

    @Query("SELECT * FROM structural_system WHERE evaluationId = :evaluationId LIMIT 1")
    suspend fun getByEvaluationId(evaluationId: Int): StructuralSystem?

    @Delete
    suspend fun delete(structuralSystem: StructuralSystem)
}
