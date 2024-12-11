package com.example.appede.presentation.home.identificacion

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Event
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.appede.data.repository.EvaluacionesRepository
import com.example.appede.presentation.home.add.AddEvaluacionScreen
import com.example.appede.presentation.home.add.AddEvaluacionViewModel
import com.example.appede.presentation.home.add.AddEvaluacionViewModelFactory
import com.example.appede.presentation.home.identificacion.SeleccionarEventoScreen

@Composable
fun IdentificacionEvaluacionNavGraph(
    repository: EvaluacionesRepository,
    usuarioId: Int,
    viewModel: AddEvaluacionViewModel
) {
    val navController = rememberNavController()

    // Crear una instancia del ViewModel usando la función viewModel()
    val viewModel: AddEvaluacionViewModel = viewModel(
        factory = AddEvaluacionViewModelFactory(repository)
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                identificacionEvalBottomNavItems.forEach { destination ->
                    NavigationBarItem(
                        selected = currentRoute == destination.route,
                        onClick = {
                            if (currentRoute != destination.route) {
                                navController.navigate(destination.route) {
                                    // Evitar múltiples instancias del mismo destino
                                    launchSingleTop = true
                                    restoreState = true
                                    popUpTo(navController.graph.startDestinationRoute!!) {
                                        saveState = true
                                    }
                                }
                            }
                        },
                        icon = { Icon(destination.icon, contentDescription = destination.label) },
                        label = { Text(destination.label) }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = IdentificacionEvalDestination.FormularioEvaluacion.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(IdentificacionEvalDestination.FormularioEvaluacion.route) {
                AddEvaluacionScreen(
                    navController = navController,
                    viewModel = viewModel,
                    usuarioId = usuarioId
                )
            }

            composable(IdentificacionEvalDestination.SeleccionarEvento.route) {
                SeleccionarEventoScreen(
                    navController = navController,
                    viewModel = viewModel,
                    usuarioId = usuarioId
                )
            }
        }
    }
}
