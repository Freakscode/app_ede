package com.example.appede.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Home : Screen("home/{userId}") {
        fun createRoute(userId: Int) = "home/$userId"
    }
    object DetallesEvaluacion : Screen("detallesEvaluacion/{evaluacionId}") {
        fun createRoute(evaluacionId: Int) = "detallesEvaluacion/$evaluacionId"
    }
    object EditarEvaluacion : Screen("editarEvaluacion/{evaluacionId}") {
        fun createRoute(evaluacionId: Int) = "editarEvaluacion/$evaluacionId"
    }

    object AddEvaluacion : Screen("add_evaluacion/{usuarioId}") {
        fun createRoute(usuarioId: Int) = "add_evaluacion/$usuarioId"
    }
}