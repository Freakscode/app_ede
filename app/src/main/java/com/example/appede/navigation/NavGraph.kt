package com.example.appede.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.appede.data.local.AppDatabase
import com.example.appede.data.repository.CommentRepository
import com.example.appede.data.repository.EvaluacionesRepository
import com.example.appede.presentation.home.add.AddEvaluacionViewModel
import com.example.appede.presentation.home.add.AddEvaluacionViewModelFactory
import com.example.appede.presentation.home.comment.CommentScreen
import com.example.appede.presentation.home.comment.CommentViewModel
import com.example.appede.presentation.home.comment.CommentViewModelFactory
import com.example.appede.presentation.home.identificacion.IdentificacionEvalDestination
import com.example.appede.presentation.home.identificacion.IdentificacionEvaluacionNavGraph
import com.example.appede.presentation.home.logged.HomeScreen
import com.example.appede.presentation.home.login.LoginScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    database: AppDatabase
) {
    val commentRepository = CommentRepository(database.commentDao())
    val evaluacionesDao = database.evaluacionesDao()
    val evaluacionesRepository = EvaluacionesRepository(
        evaluacionesDao,
        buildingIdentificationDao = database.buildingIdentificationDao(),
        buildingDescriptionDao = database.buildingDescriptionDao(),
        structuralSystemDao = database.structuralSystemDao(),
        externalRisksDao = database.externalRisksDao(),
        damageEvaluationDao = database.damageEvaluationDao(),
        commentDao = database.commentDao(),
        mediaAttachmentDao = database.mediaAttachmentDao()
    )

    Log.d("AppNavGraph", "Initializing AppNavGraph...")

    NavHost(
        navController = navController,
        startDestination = Screen.Login.route,
        modifier = modifier
    ) {
        composable(Screen.Login.route) {
            Log.d("AppNavGraph", "Navigated to LoginScreen")
            LoginScreen(
                onLoginSuccess = { userId ->
                    Log.d("AppNavGraph", "Login success! Navigating to HomeScreen with userId=$userId")
                    navController.navigate(Screen.Home.createRoute(userId)) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                }
            )
        }

        composable(
            route = Screen.Home.route,
            arguments = listOf(navArgument("userId") { type = NavType.IntType })
        ) { backStackEntry ->
            val userId = backStackEntry.arguments?.getInt("userId") ?: 0
            Log.d("AppNavGraph", "Navigated to HomeScreen with userId=$userId")
            HomeScreen(
                navController = navController,
                repository = evaluacionesRepository,
                usuarioId = userId
            )
        }

        navigation(
            route = "identificacion_nav_graph",
            startDestination = IdentificacionEvalDestination.FormularioEvaluacion.route
        ) {
            composable(
                route = IdentificacionEvalDestination.FormularioEvaluacion.route + "?usuarioId={usuarioId}",
                arguments = listOf(navArgument("usuarioId") { type = NavType.IntType })
            ) { backStackEntry ->
                val usuarioId = backStackEntry.arguments?.getInt("usuarioId") ?: 0
                Log.d("IdentificacionNavGraph", "Navigated to IdentificacionEvaluacionNavGraph with usuarioId=$usuarioId")

                val viewModel: AddEvaluacionViewModel = viewModel(
                    factory = AddEvaluacionViewModelFactory(evaluacionesRepository)
                )

                IdentificacionEvaluacionNavGraph(
                    repository = evaluacionesRepository,
                    usuarioId = usuarioId,
                    viewModel = viewModel
                )
            }
        }

    }
}
