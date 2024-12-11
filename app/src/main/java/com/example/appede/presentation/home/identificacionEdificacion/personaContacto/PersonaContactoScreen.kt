package com.example.appede.presentation.home.identificacionEdificacion.personaContacto

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appede.presentation.home.identificacionEdificacion.IdentificacionEdificacionViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonaContactoScreen(
    navController: NavController,
    viewModel: IdentificacionEdificacionViewModel
) {
    val state by viewModel.state.collectAsState()

    var nombrePersonasCont by remember { mutableStateOf(state?.nombrePersonasCont ?: "") }
    var emailPersonaCont by remember { mutableStateOf(state?.emailPersonaCont ?: "") }
    var celPersonaCont by remember { mutableStateOf(state?.celPersonaCont ?: "") }
    var responsablePersonaCont by remember { mutableStateOf(state?.responsablePersonaCont ?: "") }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Persona de Contacto") })
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
                value = nombrePersonasCont,
                onValueChange = { nombrePersonasCont = it },
                label = { Text("Nombre Completo") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = emailPersonaCont,
                onValueChange = { emailPersonaCont = it },
                label = { Text("Correo Electrónico") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = celPersonaCont,
                onValueChange = { celPersonaCont = it },
                label = { Text("Teléfono") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = responsablePersonaCont,
                onValueChange = { responsablePersonaCont = it },
                label = { Text("Responsable") },
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = {
                    viewModel.updatePersonaContacto(
                        nombrePersonasCont = nombrePersonasCont,
                        emailPersonaCont = emailPersonaCont,
                        celPersonaCont = celPersonaCont,
                        responsablePersonaCont = responsablePersonaCont
                    )
                    viewModel.savePersonaContacto()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Guardar")
            }
        }
    }
}

