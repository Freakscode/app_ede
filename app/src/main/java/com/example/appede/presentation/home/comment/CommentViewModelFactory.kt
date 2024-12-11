package com.example.appede.presentation.home.comment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appede.data.repository.CommentRepository

class CommentViewModelFactory(
    private val commentRepository: CommentRepository,
    private val evaluationId: Int,
    private val sectionName: String
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CommentViewModel::class.java)) {
            return CommentViewModel(commentRepository, evaluationId, sectionName) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
