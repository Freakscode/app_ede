package com.example.appede

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.appede.data.local.AppDatabase
import com.example.appede.data.local.ViewModel.AppViewModel
import com.example.appede.data.local.repository.appRepository
import com.example.appede.ui.EvaluacionForm
import com.example.appede.ui.EvaluacionesList
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}

@Composable
fun HomeScreen() {
    val context = LocalContext.current
    val database = AppDatabase.getInstance(context)
    val repository = appRepository(database.daoUser, database.daoEvaluaciones)
    val viewModel = AppViewModel(repository)
    //LoginScreen(viewModel)
    //EvaluacionesScreen(viewModel)
    //EvaluacionForm(viewModel)
    EvaluacionesList(viewModel)
}

@Composable
fun LoginScreen(viewModel: AppViewModel) {
    val context = LocalContext.current
    val database = AppDatabase.getInstance(context)
    val coroutineScope = rememberCoroutineScope() // Scope local para este composable

    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val loginMessage = remember { mutableStateOf("") }

    // Contenido de la pantalla
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Título
        Text(text = "Iniciar Sesión", style = MaterialTheme.typography.headlineMedium)

        // Campo de texto para el nombre de usuario
        OutlinedTextField(
            value = username.value,
            onValueChange = { username.value = it },
            label = { Text("Usuario") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de texto para la contraseña
        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botón de login
        Button(
            onClick = {
                // Validación del usuario dentro de una corrutina
                coroutineScope.launch {
                    val isValidUser =  viewModel.isValidUser(username.value, password.value)
                    loginMessage.value = if (isValidUser) {
                        "Inicio de sesión exitoso"
                    } else {
                        "Usuario o contraseña incorrectos"
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Iniciar sesión")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Mostrar el mensaje de validación
        if (loginMessage.value.isNotEmpty()) {
            Text(
                text = loginMessage.value,
                style = MaterialTheme.typography.bodyLarge,
                color = if (loginMessage.value == "Inicio de sesión exitoso") MaterialTheme.colorScheme.primary
                else MaterialTheme.colorScheme.error
            )
        }
    }
}







/*
####### Implementación inicial #######
######################################
setContentView(R.layout.main_activity)

database = Room.databaseBuilder(
application, AppDatabase::class.java, AppDatabase.DATABASE_NAME
)
.allowMainThreadQueries()
.build()
//saveUsers()


val btnUsuarios = findViewById<Button>(R.id.btnUsuarios)
val usuarios = findViewById<TextView>(R.id.usuarios)
btnUsuarios.setOnClickListener {
    lifecycleScope.launch {
        val users = database.daoUser.getAllUsers()
        users.forEach { user ->
            usuarios.append("${user.id}, ${user.email}, ${user.password}, ${user.personaId}, ${user.status}, ${user.role}\n")
        }
    }

}
}

private fun saveUsers() {
    val user1 = User(
        personaId = 123,
        email = "juan@gmail.com",
        password = "pass23dddsdc+",
        status = true,
        role = ""
    )
    val user2 = User(
        personaId = 1234,
        email = "pedro@gmail.com",
        password = "22222",
        status = true,
        role = ""
    )
    lifecycleScope.launch {
        database.daoUser.insert(user1)
        database.daoUser.insert(user2)
    }
}
}
*/
