package com.example.appede.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import com.example.appede.data.local.ViewModel.AppViewModel
import com.example.appede.data.local.entity.Evaluaciones
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun EvaluacionesList(viewModel: AppViewModel) {
    // Obtenemos las evaluaciones desde el ViewModel
    val evaluaciones by viewModel.allEvaluaciones.observeAsState(emptyList())

    // Si no hay evaluaciones, mostramos un mensaje
    if (evaluaciones.isEmpty()) {
        Text("No hay evaluaciones disponibles")
    } else {
        // Si hay evaluaciones, mostramos una lista
        LazyColumn {
            itemsIndexed(evaluaciones) { index, evaluacion ->
                // Puedes usar el índice si lo necesitas
                EvaluacionItem(evaluacion)
            }
        }
    }
}

@Composable
fun EvaluacionItem(evaluacion: Evaluaciones) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "ID: ${evaluacion.id}",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        )

        Text(
            text = "Fecha: ${evaluacion.fecha}",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colorScheme.onSurface
            )
        )

        Text(
            text = "Hora: ${evaluacion.hora}",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colorScheme.onSurface
            )
        )
    }
}