package com.example.appede.presentation.home.identificacion

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Article
import androidx.compose.material.icons.filled.Article
import androidx.compose.material.icons.filled.Event
import androidx.compose.ui.graphics.vector.ImageVector

sealed class IdentificacionEvalDestination(
    val route: String,
    val label: String,
    val icon: ImageVector
) {
    object FormularioEvaluacion : IdentificacionEvalDestination(
        route = "formulario_evaluacion",
        label = "Formulario",
        icon = Icons.AutoMirrored.Filled.Article
    )

    object SeleccionarEvento : IdentificacionEvalDestination(
        route = "seleccionar_evento",
        label = "Evento",
        icon = Icons.Default.Event
    )

    object Comments : IdentificacionEvalDestination(
        route = "comments/{sectionId}",
        label = "Comentarios",
        icon = Icons.AutoMirrored.Filled.Article // Cambia el ícono si es necesario
    ) {
        fun createRoute(sectionId: String) = "comments/$sectionId"
    }

}

val identificacionEvalBottomNavItems = listOf(
    IdentificacionEvalDestination.FormularioEvaluacion,
    IdentificacionEvalDestination.SeleccionarEvento
)
