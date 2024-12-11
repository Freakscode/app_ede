package com.example.appede.data.local.dao

import androidx.room.*
import com.example.appede.data.local.entity.BuildingIdentification
import com.example.appede.data.local.entity.Comment

@Dao
interface CommentDao {
    @Insert
    suspend fun insertComment(comment: Comment): Long

    @Query("SELECT * FROM comments WHERE evaluationId = :evaluationId AND sectionName = :sectionName")
    suspend fun getCommentsForSection(evaluationId: Int, sectionName: String): List<Comment>

    @Delete
    suspend fun deleteComment(comment: Comment)

    @Query("SELECT * FROM building_identification WHERE evaluationId = :evaluationId")
    suspend fun getByEvaluationId(evaluationId: Int): BuildingIdentification?
}
