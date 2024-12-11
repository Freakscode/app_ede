package com.example.appede.presentation.home.comment

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.appede.data.local.entity.Comment
import com.example.appede.ui.dialogs.AddCommentDialog

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommentScreen(
    commentViewModel: CommentViewModel,
    onClose: () -> Unit
) {
    // Estado que contiene los comentarios desde el ViewModel
    val comments by commentViewModel.comments.collectAsState()
    var showDialog by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        Log.d("CommentScreen", "LaunchedEffect triggered. Fetching comments.")
        commentViewModel.fetchComments()
    }

    BackHandler(showDialog) {
        showDialog = false
    }

    Scaffold(
        floatingActionButton = {
            Column {
                FloatingActionButton(
                    onClick = { onClose() },
                    modifier = Modifier.padding(bottom = 16.dp)
                ) {
                    Icon(Icons.Default.Check, contentDescription = "Confirmar y Cerrar")
                }

                FloatingActionButton(onClick = { showDialog = true }) {
                    Icon(Icons.Default.Add, contentDescription = "Agregar Comentario")
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            if (comments.isEmpty()) {
                Text(
                    text = "No hay comentarios disponibles.",
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                )
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    items(comments) { comment ->
                        CommentCard(comment = comment)
                    }
                }
            }
        }
    }

    if (showDialog) {
        AddCommentDialog(
            onDismiss = { showDialog = false },
            onSave = { text, audioPath ->
                commentViewModel.addComment(text, audioPath)
                showDialog = false
            }
        )
    }
}


@Composable
fun CommentCard(comment: Comment) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = comment.commentText,
                style = MaterialTheme.typography.bodyLarge
            )
            if (comment.audioPath != null) {
                Text(
                    text = "Audio adjunto: ${comment.audioPath}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
