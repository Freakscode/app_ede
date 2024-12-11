package com.example.appede.presentation.home.logged

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appede.data.local.entity.FullEvaluacion
import com.example.appede.data.repository.EvaluacionesRepository
import com.example.appede.navigation.Screen
import com.example.appede.presentation.home.FooterHome
import com.example.appede.presentation.home.login.HeaderHome
import com.example.appede.presentation.viewmodel.FullEvaluacionViewModelInterface
import com.example.appede.presentation.viewmodel.FullEvaluacionViewModelFactory
import com.example.appede.ui.theme.AppEDETheme
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(
    navController: NavController,
    repository: EvaluacionesRepository,
    usuarioId: Int,
    modifier: Modifier = Modifier
) {
    val viewModel: FullEvaluacionViewModelInterface = androidx.lifecycle.viewmodel.compose.viewModel(
        factory = FullEvaluacionViewModelFactory(repository, usuarioId)
    )

    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }
    val fullEvaluaciones: List<FullEvaluacion> = viewModel.state.collectAsState().value

    val filtered = if (searchQuery.text.isBlank()) fullEvaluaciones else fullEvaluaciones.filter {
        it.evaluaciones.id.toString().contains(searchQuery.text, ignoreCase = true)
    }

    Column(modifier = modifier.fillMaxSize()) {
        HeaderHome()

        SearchBar(
            query = searchQuery,
            onQueryChange = { searchQuery = it },
            onSearchClick = {},
            modifier = Modifier.padding(top = 16.dp, start = 4.dp, end = 4.dp)
        )

        EvaluationList(
            evaluaciones = filtered,
            navController = navController,
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.height(4.dp))

        Button(
            onClick = {
                navController.navigate("formulario_evaluacion?usuarioId=$usuarioId")
            },
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primaryContainer),
            shape = RoundedCornerShape(50),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(60.dp)
        ) {
            Text(
                "Agregar Evaluación",
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                fontSize = 20.sp
            )
        }


        Spacer(modifier = Modifier.height(30.dp))

        FooterHome()
    }
}

@Composable
fun SearchBar(
    query: TextFieldValue,
    onQueryChange: (TextFieldValue) -> Unit,
    onSearchClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = query,
            onValueChange = onQueryChange,
            placeholder = { Text("Buscar incidente por código") },
            trailingIcon = {
                IconButton(onClick = onSearchClick) {
                    Icon(Icons.Default.Search, contentDescription = "Buscar")
                }
            },
            shape = RoundedCornerShape(50),
            modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(50))
        )
    }
}

@Composable
fun EvaluationList(
    evaluaciones: List<FullEvaluacion>,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier.fillMaxWidth()) {
        items(evaluaciones) { fullEvaluacion ->
            EvaluationCard(
                fullEvaluacion = fullEvaluacion,
                onViewClick = {
                    navController.navigate(Screen.DetallesEvaluacion.createRoute(fullEvaluacion.evaluaciones.id))
                },
                onEditClick = {
                    navController.navigate(Screen.EditarEvaluacion.createRoute(fullEvaluacion.evaluaciones.id))
                },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 8.dp)
            )
        }
    }
}

