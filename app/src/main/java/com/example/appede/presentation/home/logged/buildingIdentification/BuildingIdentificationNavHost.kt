package com.example.appede.presentation.home.logged.buildingIdentification

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.appede.data.repository.BuildingIdentificationRepository
import com.example.appede.presentation.viewmodel.BuildingIdentificationViewModel

@Composable
fun BuildingIdentificationNavHost(
    parentNavController: NavHostController,
    evaluationId: Int,
    repository: BuildingIdentificationRepository,
    modifier: Modifier = Modifier
) {
    val factory = BuildingIdentificationViewModelFactory(repository, evaluationId)
    val viewModel = viewModel<BuildingIdentificationViewModel>(factory = factory)

    NavHost(
        navController = parentNavController,
        startDestination = "ubicacion",
        modifier = modifier
    ) {
        composable("ubicacion") {
            BuildingIdentificationUbicacionScreen(
                viewModel = viewModel,
                onNextClick = { parentNavController.navigate("info_general") },
                onBackClick = { parentNavController.popBackStack() }
            )
        }

        composable("info_general") {
            BuildingIdentificationInfoGeneralScreen(
                viewModel = viewModel,
                onNextClick = {
                    // Aquí podrías navegar a la siguiente sección
                    parentNavController.popBackStack()
                },
                onBackClick = { parentNavController.popBackStack() }
            )
        }
    }
}
