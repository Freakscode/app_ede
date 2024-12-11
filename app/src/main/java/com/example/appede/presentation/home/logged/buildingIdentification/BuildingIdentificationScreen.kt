package com.example.appede.presentation.home.logged.buildingIdentification

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appede.presentation.viewmodel.BuildingIdentificationViewModel

@Composable
fun BuildingIdentificationUbicacionScreen(
    viewModel: BuildingIdentificationViewModel,
    onNextClick: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val state by viewModel.state.collectAsState()

    var municipio by remember { mutableStateOf(state?.municipio ?: "") }
    var barrio by remember { mutableStateOf(state?.barrio ?: "") }
    var numVia by remember { mutableStateOf(state?.numVia ?: "") }
    var apVia by remember { mutableStateOf(state?.apVia ?: "") }
    var orientacionVia by remember { mutableStateOf(state?.orientacionVia ?: "") }
    var numCruce by remember { mutableStateOf(state?.numCruce ?: "") }
    var orientacionCruce by remember { mutableStateOf(state?.orientacionCruce ?: "") }
    var complemento by remember { mutableStateOf(state?.complemento ?: "") }
    var catastro by remember { mutableStateOf(state?.catastro ?: "") }
    var lat by remember { mutableStateOf(state?.lat ?: "") }
    var lon by remember { mutableStateOf(state?.lon ?: "") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text("Ubicación y Datos Catastrales", style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(value = municipio, onValueChange = { municipio = it }, label = { Text("Municipio") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = barrio, onValueChange = { barrio = it }, label = { Text("Barrio") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = numVia, onValueChange = { numVia = it }, label = { Text("Número Vía") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = apVia, onValueChange = { apVia = it }, label = { Text("AP Vía") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = orientacionVia, onValueChange = { orientacionVia = it }, label = { Text("Orientación Vía") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = numCruce, onValueChange = { numCruce = it }, label = { Text("Número Cruce") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = orientacionCruce, onValueChange = { orientacionCruce = it }, label = { Text("Orientación Cruce") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = complemento, onValueChange = { complemento = it }, label = { Text("Complemento") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = catastro, onValueChange = { catastro = it }, label = { Text("Catastro") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = lat, onValueChange = { lat = it }, label = { Text("Latitud") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = lon, onValueChange = { lon = it }, label = { Text("Longitud") }, modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Button(onClick = { onBackClick() }) {
                Text("Atrás")
            }
            Button(onClick = {
                // Guardar cambios antes de ir a la siguiente subsección
                viewModel.updateBuildingIdentification(
                    nombreEdificacion = state?.nombreEdificacion ?: "",
                    municipioId = municipio,
                    barrioId = barrio,
                    numVia = numVia,
                    apVia = apVia,
                    orientacionVia = orientacionVia,
                    numCruce = numCruce,
                    orientacionCruce = orientacionCruce,
                    complemento = complemento,
                    catastro = catastro,
                    lat = lat,
                    lon = lon,
                    tipoPropiedad = state?.tipoPropiedad ?: ""
                )
                onNextClick()
            }) {
                Text("Siguiente")
            }
        }
    }
}


