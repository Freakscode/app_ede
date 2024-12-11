package com.example.appede.presentation.home.identificacion

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appede.R
import com.example.appede.presentation.home.add.AddEvaluacionViewModel

data class Evento(val nombre: String, val iconRes: Int)

val listaEventos = listOf(
    Evento("Inundación", R.drawable.ic_inundacion),
    Evento("Deslizamiento", R.drawable.ic_deslizamiento),
    Evento("Sismo", R.drawable.ic_sismo),
    Evento("Viento", R.drawable.ic_viento),
    Evento("Incendio", R.drawable.ic_incendio),
    Evento("Explosión", R.drawable.ic_explosion),
    Evento("Estructural", R.drawable.ic_estructural),
    Evento("Otro", R.drawable.ic_otro)
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SeleccionarEventoScreen(
    navController: NavController,
    viewModel: AddEvaluacionViewModel,
    usuarioId: Int,
) {
    var selectedEvent by remember { mutableStateOf(viewModel.tipoEvaluacion.value) }
    Log.d("SeleccionarEventoScreen", "Screen loaded with usuarioId=$usuarioId, selectedEvent=$selectedEvent")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(listaEventos) { evento ->
                EventItem(
                    evento = evento,
                    isSelected = (evento.nombre == selectedEvent),
                    onClick = {
                        Log.d("SeleccionarEventoScreen", "Event selected: ${evento.nombre}")
                        selectedEvent = evento.nombre
                        viewModel.setTipoEvaluacion(evento.nombre)
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            Log.d("SeleccionarEventoScreen", "Saving evaluation for usuarioId=$usuarioId with selectedEvent=$selectedEvent")
            viewModel.saveEvaluation(usuarioId)
            navController.popBackStack()
        }) {
            Text("CONTINUAR")
        }
    }
}

@Composable
fun EventItem(
    evento: Evento,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val borderColor = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f)

    ElevatedCard(
        onClick = onClick,
        modifier = Modifier
            .size(140.dp)
            .border(2.dp, borderColor, shape = MaterialTheme.shapes.medium),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = evento.iconRes),
                contentDescription = evento.nombre,
                modifier = Modifier.size(64.dp),
                tint = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = evento.nombre,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
