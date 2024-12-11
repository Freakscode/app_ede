package com.example.appede.presentation.home.comment

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appede.data.local.entity.Comment
import com.example.appede.data.repository.CommentRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CommentViewModel(
    private val commentRepository: CommentRepository,
    private val evaluationId: Int,
    private val sectionName: String
) : ViewModel() {

    private val _comments = MutableStateFlow<List<Comment>>(emptyList())
    val comments: StateFlow<List<Comment>> get() = _comments

    init {
        fetchComments()
    }

    fun fetchComments() {
        viewModelScope.launch {
            try {
                Log.d("CommentViewModel", "Fetching comments for evaluationId: $evaluationId, sectionName: $sectionName")
                val fetchedComments = commentRepository.getComments(evaluationId, sectionName)
                Log.d("CommentViewModel", "Fetched comments: ${fetchedComments.size} comments")
                _comments.value = fetchedComments
            } catch (e: Exception) {
                Log.e("CommentViewModel", "Error fetching comments", e)
            }
        }
    }

    fun addComment(text: String, audioPath: String?) {
        viewModelScope.launch {
            val newComment = Comment(
                evaluationId = evaluationId,
                sectionName = sectionName,
                commentText = text,
                audioPath = audioPath
            )
            commentRepository.addComment(newComment)
            fetchComments() // Refrescar comentarios inmediatamente después de agregar
        }
    }

    fun deleteComment(comment: Comment) {
        viewModelScope.launch {
            commentRepository.deleteComment(comment)
            fetchComments()
        }
    }
}
