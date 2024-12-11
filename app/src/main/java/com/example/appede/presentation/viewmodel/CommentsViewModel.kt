package com.example.appede.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appede.data.local.entity.Comment
import com.example.appede.data.repository.CommentRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CommentViewModel(
    private val repository: CommentRepository,
    private val evaluationId: Int
) : ViewModel() {

    private val _comments = MutableStateFlow<List<Comment>>(emptyList())
    val comments: StateFlow<List<Comment>> = _comments

    // Cargar comentarios para una sección específica
    fun loadCommentsForSection(sectionName: String) {
        viewModelScope.launch {
            _comments.value = repository.getComments(evaluationId, sectionName)
        }
    }

    fun addComment(sectionName: String, commentText: String) {
        viewModelScope.launch {
            repository.addComment(
                Comment(
                    evaluationId = evaluationId,
                    sectionName = sectionName,
                    commentText = commentText
                )
            )
            // Recarga comentarios luego de agregar uno nuevo
            _comments.value = repository.getComments(evaluationId, sectionName)
        }
    }
}
