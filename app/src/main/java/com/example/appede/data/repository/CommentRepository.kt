package com.example.appede.data.repository

import com.example.appede.data.local.dao.CommentDao
import com.example.appede.data.local.entity.Comment

class CommentRepository(private val commentDao: CommentDao) {
    suspend fun addComment(comment: Comment) = commentDao.insertComment(comment)
    suspend fun getComments(evaluationId: Int, sectionName: String) = commentDao.getCommentsForSection(evaluationId, sectionName)
    suspend fun deleteComment(comment: Comment) = commentDao.deleteComment(comment)
}
