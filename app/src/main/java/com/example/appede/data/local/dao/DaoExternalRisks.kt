package com.example.appede.data.local.dao

import androidx.room.*
import com.example.appede.data.local.entity.ExternalRisks

@Dao
interface ExternalRisksDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(externalRisks: ExternalRisks): Long

    @Query("SELECT * FROM external_risks WHERE evaluationId = :evaluationId LIMIT 1")
    suspend fun getByEvaluationId(evaluationId: Int): ExternalRisks?

    @Delete
    suspend fun delete(externalRisks: ExternalRisks)
}
