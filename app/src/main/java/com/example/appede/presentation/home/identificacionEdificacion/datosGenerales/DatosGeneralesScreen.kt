package com.example.appede.presentation.home.identificacionEdificacion.datosGenerales

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appede.presentation.home.identificacionEdificacion.IdentificacionEdificacionViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatosGeneralesScreen(
    navController: NavController,
    viewModel: IdentificacionEdificacionViewModel
) {
    val state by viewModel.state.collectAsState()

    var nombreEdificacion by remember { mutableStateOf(state?.nombreEdificacion ?: "") }
    var municipio by remember { mutableStateOf(state?.municipio ?: "") }
    var barrio by remember { mutableStateOf(state?.barrio ?: "") }
    var tipoPropiedad by remember { mutableStateOf(state?.tipoPropiedad ?: "") }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Datos Generales") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = nombreEdificacion,
                onValueChange = { nombreEdificacion = it },
                label = { Text("Nombre Edificación") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = municipio,
                onValueChange = { municipio = it },
                label = { Text("Municipio") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = barrio,
                onValueChange = { barrio = it },
                label = { Text("Barrio") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = tipoPropiedad,
                onValueChange = { tipoPropiedad = it },
                label = { Text("Tipo de Propiedad") },
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = {
                    viewModel.updateDatosGenerales(
                        nombreEdificacion = nombreEdificacion,
                        municipio = municipio,
                        barrio = barrio,
                        tipoPropiedad = tipoPropiedad
                    )
                    viewModel.saveDatosGenerales()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Guardar")
            }
        }
    }
}
