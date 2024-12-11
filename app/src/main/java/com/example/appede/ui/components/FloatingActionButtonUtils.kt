package com.example.appede.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Textsms
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp

@Composable
fun DraggableFab(
    x: Float,
    y: Float,
    screenWidth: Float,
    onPositionChange: (Float, Float) -> Unit,
    onClick: () -> Unit
) {
    var isDragging by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .absoluteOffset(x = x.dp, y = y.dp)
            .size(56.dp)
            .shadow(8.dp, CircleShape)
            .background(Color.Blue, CircleShape)
            .pointerInput(Unit) {
                detectDragGestures(
                    onDragStart = { isDragging = true },
                    onDragEnd = {
                        isDragging = false
                        val adjustedX = if (x < screenWidth / 2) 0f else screenWidth - 56f
                        onPositionChange(adjustedX, y)
                    },
                    onDrag = { change, dragAmount ->
                        change.consume()
                        onPositionChange((x + dragAmount.x).coerceIn(0f, screenWidth - 56f), y + dragAmount.y)
                    }
                )
            },
        contentAlignment = Alignment.Center
    ) {
        IconButton(onClick = { if (!isDragging) onClick() }) {
            Icon(
                imageVector = Icons.Default.Textsms,
                contentDescription = "Agregar Comentario",
                tint = Color.White
            )
        }
    }
}
