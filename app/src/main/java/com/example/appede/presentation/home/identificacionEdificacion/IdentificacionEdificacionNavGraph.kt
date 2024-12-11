package com.example.appede.presentation.home.identificacionEdificacion

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.appede.data.repository.BuildingIdentificationRepository
import com.example.appede.presentation.home.identificacionEdificacion.datosGenerales.DatosGeneralesScreen
import com.example.appede.presentation.home.identificacionEdificacion.identificacionCatastralLocalizacion.IdentificacionCatastralLocalizacionScreen
import com.example.appede.presentation.home.identificacionEdificacion.personaContacto.PersonaContactoScreen

@Composable
fun IdentificacionEdificacionNavGraph(
    repository: BuildingIdentificationRepository,
    evaluationId: Int,
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    val viewModel: IdentificacionEdificacionViewModel = viewModel(
        factory = IdentificacionEdificacionViewModelFactory(repository, evaluationId)
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                identificacionEdificacionNavItems.forEach { destination ->
                    NavigationBarItem(
                        selected = currentRoute == destination.route,
                        onClick = {
                            if (currentRoute != destination.route) {
                                navController.navigate(destination.route) {
                                    popUpTo(navController.graph.startDestinationRoute!!) { saveState = true }
                                    launchSingleTop = true
                                    restoreState = true
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
            startDestination = IdentificacionEdificacionDestination.DatosGenerales.route,
            modifier = modifier.padding(innerPadding)
        ) {
            composable(IdentificacionEdificacionDestination.DatosGenerales.route) {
                DatosGeneralesScreen(navController, viewModel)
            }
            composable(IdentificacionEdificacionDestination.IdentificacionCatastralLocalizacion.route) {
                IdentificacionCatastralLocalizacionScreen(navController, viewModel)
            }
            composable(IdentificacionEdificacionDestination.PersonaContacto.route) {
                PersonaContactoScreen(navController, viewModel)
            }
            // Agrega más composables aquí si incorporas más destinos
        }
    }
}
