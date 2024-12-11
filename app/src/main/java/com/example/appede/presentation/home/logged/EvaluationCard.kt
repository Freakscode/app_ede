package com.example.appede.presentation.home.logged

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appede.data.local.entity.Evaluaciones
import com.example.appede.data.local.entity.FullEvaluacion
import com.example.appede.ui.theme.AppEDETheme

@Composable
fun EvaluationCard(
    fullEvaluacion: FullEvaluacion,
    onViewClick: () -> Unit,
    onEditClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val eval = fullEvaluacion.evaluaciones
    val barrioId = fullEvaluacion.buildingIdentification?.barrio ?: "Desconocido"

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Primera Columna
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "${eval.id} - ${eval.tipoEvaluacion}",
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${eval.hora} - Grupo ${eval.idGrupo}",
                    style = MaterialTheme.typography.bodySmall
                )
            }

            // Segunda Columna
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = eval.fecha,
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Barrio: $barrioId",
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Icon(
                imageVector = Icons.Filled.Visibility,
                contentDescription = "Ver Detalles",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .size(36.dp)
                    .padding(end = 8.dp)
                    .clickable { onViewClick() }
            )

            Icon(
                imageVector = Icons.Filled.Edit,
                contentDescription = "Editar Evaluación",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .size(34.dp)
                    .clickable { onEditClick() }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EvaluationCardPreview() {
    val dummyEval = Evaluaciones(
        id = 23943,
        usuarioId = 1,
        fecha = "2024-01-15",
        hora = "10:30",
        idGrupo = 1,
        tipoEvaluacion = "SISMO",
        nombrePersonasCont = "Juan Pérez",
        emailPersonaCont = "juan.perez@dgrd.com",
        celPersonaCont = "3001234567",
        responsablePersonaCont = "Maria Gómez",
        firmaPath = ""
    )

    val dummyFullEval = FullEvaluacion(
        evaluaciones = dummyEval,
        buildingIdentification = null,
        buildingDescription = null,
        structuralSystem = null,
        externalRisks = null,
        damageEvaluation = null,
        comment = null,
        mediaAttachment = null
    )

    AppEDETheme {
        EvaluationCard(
            fullEvaluacion = dummyFullEval,
            onViewClick = {},
            onEditClick = {}
        )
    }
}
