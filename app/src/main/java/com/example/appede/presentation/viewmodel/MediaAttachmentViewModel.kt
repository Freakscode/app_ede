package com.example.appede.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appede.data.local.entity.MediaAttachment
import com.example.appede.data.repository.MediaAttachmentRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MediaAttachmentViewModel(
    private val repository: MediaAttachmentRepository,
    private val evaluationId: Int
) : ViewModel() {

    private val _attachments = MutableStateFlow<List<MediaAttachment>>(emptyList())
    val attachments: StateFlow<List<MediaAttachment>> = _attachments

    fun loadMediaForSection(sectionName: String) {
        viewModelScope.launch {
            _attachments.value = repository.getMedia(evaluationId, sectionName)
        }
    }

    fun addMediaAttachment(sectionName: String, mediaType: String, fileUri: String) {
        viewModelScope.launch {
            repository.addMedia(
                MediaAttachment(
                    evaluationId = evaluationId,
                    sectionName = sectionName,
                    mediaType = mediaType,
                    fileUri = fileUri
                )
            )
            _attachments.value = repository.getMedia(evaluationId, sectionName)
        }
    }
}
