package com.example.appede.data.local.dao

import androidx.room.*
import com.example.appede.data.local.entity.DamageEvaluation

@Dao
interface DamageEvaluationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(damageEvaluation: DamageEvaluation): Long

    @Query("SELECT * FROM damage_evaluation WHERE evaluationId = :evaluationId LIMIT 1")
    suspend fun getByEvaluationId(evaluationId: Int): DamageEvaluation?

    @Delete
    suspend fun delete(damageEvaluation: DamageEvaluation)
}
