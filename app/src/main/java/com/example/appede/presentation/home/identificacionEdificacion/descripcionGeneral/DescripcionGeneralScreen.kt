package com.example.appede.presentation.home.identificacionEdificacion.descripcionGeneral

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appede.presentation.home.identificacionEdificacion.descripcionGeneral.DescripcionGeneralViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DescripcionGeneralScreen(
    navController: NavController,
    viewModel: DescripcionGeneralViewModel
) {
    val state by viewModel.state.collectAsState()

    var numVia by remember { mutableStateOf(state?.numVia ?: "") }
    var apVia by remember { mutableStateOf(state?.apVia ?: "") }
    var orientacionVia by remember { mutableStateOf(state?.orientacionVia ?: "") }
    var numCruce by remember { mutableStateOf(state?.numCruce ?: "") }
    var orientacionCruce by remember { mutableStateOf(state?.orientacionCruce ?: "") }
    var complemento by remember { mutableStateOf(state?.complemento ?: "") }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Descripción General") })
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
                value = numVia,
                onValueChange = { numVia = it },
                label = { Text("Número Vía") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = apVia,
                onValueChange = { apVia = it },
                label = { Text("Avenida/Calle") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = orientacionVia,
                onValueChange = { orientacionVia = it },
                label = { Text("Orientación Vía") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = numCruce,
                onValueChange = { numCruce = it },
                label = { Text("Número Cruce") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = orientacionCruce,
                onValueChange = { orientacionCruce = it },
                label = { Text("Orientación Cruce") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = complemento,
                onValueChange = { complemento = it },
                label = { Text("Complemento") },
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = {
                    viewModel.updateDescripcionGeneral(
                        numVia = numVia,
                        apVia = apVia,
                        orientacionVia = orientacionVia,
                        numCruce = numCruce,
                        orientacionCruce = orientacionCruce,
                        complemento = complemento
                    )
                    viewModel.saveDescripcionGeneral()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Guardar")
            }
        }
    }
}
