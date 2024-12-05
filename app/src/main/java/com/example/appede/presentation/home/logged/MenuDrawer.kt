package com.example.appede.presentation.home.logged

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )

    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                DrawerContent()
            }
        }
    ) {
        Scaffold (
            topBar = {
                TopBar(
                    onOpenDrawer = {
                        scope.launch{
                            drawerState.apply{
                                if (isClosed) open() else close()
                            }
                        }
                    },
                    title = title
                )
            }
        ) { padding ->
            ScreenContent(modifier = modifier.padding(padding))
        }
    }
}

@Composable
fun DrawerContent(
    modifier: Modifier = Modifier
){

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
                modifier = Modifier.padding(end = 16.dp)
                    .height(95.dp),
            ) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
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