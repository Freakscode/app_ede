package com.example.appede.presentation.home.add

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Comment
import androidx.compose.material.icons.filled.Upload
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEvaluacionScreen(
    navController: NavController,
    viewModel: AddEvaluacionViewModel,
    usuarioId: Int,
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()

    val nombreEvaluador by viewModel.nombreEvaluador.collectAsState()
    val idEvento by viewModel.idEvento.collectAsState()
    val idGrupo by viewModel.idGrupo.collectAsState()
    val dependenciaEntidad by viewModel.dependenciaEntidad.collectAsState()
    val firmaPath by viewModel.firmaPath.collectAsState()

    var showError by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val evaluationId by viewModel.evaluationId.collectAsState()

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let { viewModel.onFirmaPathChange(it.toString()) }
    }

    LaunchedEffect(evaluationId) {
        if (evaluationId != null && evaluationId != 0) {
            navController.navigate("comments?evaluationId=${evaluationId}&sectionName=formulario_evaluacion")
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Nueva Evaluación") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Regresar")
                    }
                }
            )
        },
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(scrollState)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "IDENTIFICACIÓN DE LA EVALUACIÓN",
                style = MaterialTheme.typography.titleMedium,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            OutlinedTextField(
                value = nombreEvaluador,
                onValueChange = {
                    viewModel.onNombreEvaluadorChange(it)
                    showError = false
                },
                label = { Text("*Nombre Evaluador") },
                modifier = Modifier.fillMaxWidth(),
                isError = showError && nombreEvaluador.isEmpty()
            )

            OutlinedTextField(
                value = idEvento,
                onValueChange = { viewModel.onIdEventoChange(it) },
                label = { Text("ID Evento (Opcional)") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = idGrupo,
                onValueChange = {
                    viewModel.onIdGrupoChange(it)
                    showError = false
                },
                label = { Text("*ID Grupo") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth(),
                isError = showError && idGrupo.isEmpty()
            )

            OutlinedTextField(
                value = dependenciaEntidad,
                onValueChange = {
                    viewModel.onDependenciaEntidadChange(it)
                    showError = false
                },
                label = { Text("*Dependencia / Entidad") },
                modifier = Modifier.fillMaxWidth(),
                isError = showError && dependenciaEntidad.isEmpty()
            )

            Button(
                onClick = { launcher.launch("image/*") },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary
                )
            ) {
                Icon(imageVector = Icons.Default.Upload, contentDescription = "Subir Firma")
                Spacer(modifier = Modifier.width(8.dp))
                Text("SUBIR FIRMA")
            }

            if (firmaPath.isNotEmpty()) {
                Text(
                    text = "Firma seleccionada: ${firmaPath.substringAfterLast("/")}",
                    color = MaterialTheme.colorScheme.primary
                )
            }

            if (showError) {
                Text(
                    text = errorMessage ?: "Por favor, completa todos los campos obligatorios.",
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}
