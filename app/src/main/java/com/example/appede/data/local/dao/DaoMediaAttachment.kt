package com.example.appede.data.local.dao

import androidx.room.*
import com.example.appede.data.local.entity.BuildingIdentification
import com.example.appede.data.local.entity.MediaAttachment

@Dao
interface MediaAttachmentDao {
    @Insert
    suspend fun insertMedia(media: MediaAttachment): Long

    @Query("SELECT * FROM media_attachments WHERE evaluationId = :evaluationId AND sectionName = :sectionName")
    suspend fun getMediaForSection(evaluationId: Int, sectionName: String): List<MediaAttachment>

    @Delete
    suspend fun deleteMedia(media: MediaAttachment)

    @Query("SELECT * FROM building_identification WHERE evaluationId = :evaluationId")
    suspend fun getByEvaluationId(evaluationId: Int): BuildingIdentification?
}
