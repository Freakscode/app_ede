package com.example.appede.presentation.home.identificacionEdificacion.identificacionCatastralLocalizacion

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appede.presentation.home.identificacionEdificacion.IdentificacionEdificacionViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IdentificacionCatastralLocalizacionScreen(
    navController: NavController,
    viewModel: IdentificacionEdificacionViewModel
) {
    val state by viewModel.state.collectAsState()

    var catastro by remember { mutableStateOf(state?.catastro ?: "") }
    var lat by remember { mutableStateOf(state?.lat ?: "") }
    var lon by remember { mutableStateOf(state?.lon ?: "") }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Catastro y Localización") })
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
                value = catastro,
                onValueChange = { catastro = it },
                label = { Text("Número Catastro") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = lat,
                onValueChange = { lat = it },
                label = { Text("Latitud") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = lon,
                onValueChange = { lon = it },
                label = { Text("Longitud") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = {
                    viewModel.updateCatastralLocalizacion(
                        catastro = catastro,
                        lat = lat,
                        lon = lon
                    )
                    viewModel.saveCatastralLocalizacion()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Guardar")
            }
        }
    }
}
