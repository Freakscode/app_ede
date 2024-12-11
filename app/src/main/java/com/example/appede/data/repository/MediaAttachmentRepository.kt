package com.example.appede.data.repository

import com.example.appede.data.local.dao.MediaAttachmentDao
import com.example.appede.data.local.entity.MediaAttachment

class MediaAttachmentRepository(private val mediaDao: MediaAttachmentDao) {
    suspend fun addMedia(media: MediaAttachment) = mediaDao.insertMedia(media)
    suspend fun getMedia(evaluationId: Int, sectionName: String) = mediaDao.getMediaForSection(evaluationId, sectionName)
    suspend fun deleteMedia(media: MediaAttachment) = mediaDao.deleteMedia(media)
}
