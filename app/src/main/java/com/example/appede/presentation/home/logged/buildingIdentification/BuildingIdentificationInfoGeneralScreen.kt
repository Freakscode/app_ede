package com.example.appede.presentation.home.logged.buildingIdentification

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appede.presentation.viewmodel.BuildingIdentificationViewModelInterface
import com.example.appede.presentation.viewmodel.FakeBuildingIdentificationViewModel

@Composable
fun BuildingIdentificationInfoGeneralScreen(
    viewModel: BuildingIdentificationViewModelInterface,
    onNextClick: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val state by viewModel.state.collectAsState()

    var nombreEdificacion by remember { mutableStateOf(state?.nombreEdificacion ?: "") }
    var tipoPropiedad by remember { mutableStateOf(state?.tipoPropiedad ?: "") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text("Información General de la Edificación", style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = nombreEdificacion,
            onValueChange = { nombreEdificacion = it },
            label = { Text("Nombre de la Edificación") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = tipoPropiedad,
            onValueChange = { tipoPropiedad = it },
            label = { Text("Tipo de Propiedad") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Button(onClick = { onBackClick() }) {
                Text("Atrás")
            }
            Button(onClick = {
                viewModel.updateBuildingIdentification(
                    nombreEdificacion = nombreEdificacion,
                    municipioId = state?.municipio ?: "",
                    barrioId = state?.barrio ?: "",
                    numVia = state?.numVia ?: "",
                    apVia = state?.apVia ?: "",
                    orientacionVia = state?.orientacionVia ?: "",
                    numCruce = state?.numCruce ?: "",
                    orientacionCruce = state?.orientacionCruce ?: "",
                    complemento = state?.complemento ?: "",
                    catastro = state?.catastro ?: "",
                    lat = state?.lat ?: "",
                    lon = state?.lon ?: "",
                    tipoPropiedad = tipoPropiedad
                )
                onNextClick()
            }) {
                Text("Finalizar Sección")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BuildingIdentificationInfoGeneralScreenPreview() {
    val fakeViewModel = FakeBuildingIdentificationViewModel()
    BuildingIdentificationInfoGeneralScreen(
        viewModel = fakeViewModel,
        onBackClick = {},
        onNextClick = {}
    )
}
