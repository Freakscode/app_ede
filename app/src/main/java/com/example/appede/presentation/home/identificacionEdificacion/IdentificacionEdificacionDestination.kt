package com.example.appede.presentation.home.identificacionEdificacion

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class IdentificacionEdificacionDestination(
    val route: String,
    val label: String,
    val icon: ImageVector
) {
    object DatosGenerales : IdentificacionEdificacionDestination(
        route = "datos_generales",
        label = "Datos Generales",
        icon = Icons.Filled.Build
    )

    object IdentificacionCatastralLocalizacion : IdentificacionEdificacionDestination(
        route = "identificacion_catastral_localizacion",
        label = "Catastro y GPS",
        icon = Icons.Filled.LocationOn
    )

    object PersonaContacto : IdentificacionEdificacionDestination(
        route = "persona_contacto",
        label = "Contacto",
        icon = Icons.Filled.Person
    )

    // Puedes agregar más destinos aquí si los necesitas,
    // por ejemplo DescripcionGeneral o UsosPredominantes
    // siguiendo el mismo patrón.
}

val identificacionEdificacionNavItems = listOf(
    IdentificacionEdificacionDestination.DatosGenerales,
    IdentificacionEdificacionDestination.IdentificacionCatastralLocalizacion,
    IdentificacionEdificacionDestination.PersonaContacto
    // Agrega más items aquí si agregas más destinos
)
