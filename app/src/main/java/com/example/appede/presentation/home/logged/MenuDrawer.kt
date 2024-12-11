package com.example.appede.presentation.home.logged

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appede.ui.theme.AppEDETheme
import kotlinx.coroutines.launch

@Composable
fun MenuDrawer(
    modifier: Modifier = Modifier,
    title: String = "DAGRD - APP EDE",
){
    ModalDrawerSheet(
        modifier = Modifier.width(LocalConfiguration.current.screenWidthDp.dp * 0.6f),
    ) {
        DrawerContent()
    }
}

@Composable
fun DrawerContent(
    modifier: Modifier = Modifier
) {
    // Lista de elementos del menú con subitems
    val menuItems = listOf(
        "Identificación de la evaluación" to emptyList<String>(),
        "Identificación de la edificación" to listOf(
            "Datos Generales",
            "Identificación Catastral",
            "Persona de Contacto"
        ),
        "Descripción de la Edificación" to listOf(
            "Características Generales",
            "Usos Predominantes",
            "Sistema estructural y material" to listOf(
                "Sistema Estructural",
                "Material"
            ),
            "Sistemas de Entrepiso",
            "Sistemas de Cubierta" to listOf(
                "Sistema de soporte",
                "Revestimiento"
            ),
            "Elementos no estructurales adicionales" to listOf(
                "Muros Divisorios",
                "Fachadas",
                "Escaleras"
            )
        ),
        "Identificación de Riesgos Externos" to emptyList<String>(),
        "Evaluación de Daños en la Edificación" to listOf(
            "Determinar la existencia de las siguientes condiciones",
            "Establecer el nivel de daño de los siguientes elementos",
            "Alcance de la evaluación"
        ),
        "Nivel de daño en la edificación" to listOf(
            "Porcentaje de Afectación de la Edificación en Planta",
            "Severidad de Daños",
            "Nivel de daño en la edificación"
        ),
        "Habitabilidad de la Edificación" to emptyList<String>()
    )

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {

        Text(
            text = "GUÍA EDE",
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 30.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)

        )

        HorizontalDivider()

        // Iteramos por cada elemento del menú
        menuItems.forEach { (mainItem, subItems) ->
            if (subItems.isEmpty()) {
                // Ítem sin subitems (clicable estándar)
                StandardMenuItem(mainItem)
            } else {
                // Ítem con subitems (desplegable)
                ExpandableMenuItem(mainItem = mainItem, subItems = subItems)
            }
        }
    }
}

@Composable
fun StandardMenuItem(
    mainItem: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* Acción para ítem estándar */ }
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = mainItem,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f) // Asegura que el texto ocupe todo el espacio disponible
        )
    }
}

@Composable
fun ExpandableMenuItem(
    mainItem: String,
    subItems: List<Any>
) {
    // Estado para controlar si el menú está expandido
    var isExpanded by remember { mutableStateOf(false) }

    Column {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { isExpanded = !isExpanded } // Alternar el estado de expansión
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = mainItem,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.weight(1f) // Asegura que el texto ocupe todo el espacio disponible
            )
            Icon(
                imageVector = if (isExpanded) Icons.Default.KeyboardArrowDown else Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = if (isExpanded) "Colapsar" else "Expandir"
            )
        }

        // Subitems (visibles solo si está expandido)
        if (isExpanded) {
            subItems.forEach { subItem ->
                if (subItem is String) {
                    Text(
                        text = subItem,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier
                            .padding(start = 16.dp, top = 4.dp, bottom = 4.dp)
                            .clickable { /* Acción para subelemento */ }
                    )
                } else if (subItem is List<*>) {
                    subItem.forEach { nestedSubItem ->
                        if (nestedSubItem is String) {
                            Text(
                                text = nestedSubItem,
                                style = MaterialTheme.typography.bodySmall,
                                modifier = Modifier
                                    .padding(start = 32.dp, top = 2.dp, bottom = 2.dp)
                                    .clickable { /* Acción para subsubelemento */ }
                            )
                        }
                    }
                }
            }
        }
    }
}




@Composable
fun ScreenContent(
    modifier: Modifier = Modifier
){

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    onOpenDrawer: () -> Unit,
    title: String
) {
    CenterAlignedTopAppBar(
        modifier = Modifier
            .height(100.dp)
            .clip(RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
        ),
        navigationIcon = {
            IconButton(
                onClick = onOpenDrawer,
                modifier = Modifier.padding(start = 16.dp, top = 25.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu",
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(40.dp)
                )
            }
        },
        title = {
            Text(
                text = title,
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = 30.sp,
                modifier = Modifier.padding(top =30.dp),
                maxLines = 1
            )
        },
        actions = {
            IconButton(
                onClick = { /* Acción del icono de cuenta */ },
                modifier = Modifier.padding(end = 12.dp)
                    .height(95.dp),
            ) {
                Icon(
                    imageVector = Icons.Default.Save,
                    contentDescription = "Account",
                    modifier = Modifier.size(40.dp),
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    )
}

@Preview(
    showBackground = true,
)
@Composable
fun MenuDrawerPreview() {
    AppEDETheme {
         MenuDrawer()
    }
}

@Preview(
    showBackground = true,
)
@Composable
fun ScreenContentPreview() {
    AppEDETheme {
        ScreenContent()
    }
}

@Preview(
    showBackground = true,
)
@Composable
fun TopBarPreview() {
    AppEDETheme {
        TopBar(
            onOpenDrawer = {},
            title = "DAGRD - APP EDE"
        )
    }
}