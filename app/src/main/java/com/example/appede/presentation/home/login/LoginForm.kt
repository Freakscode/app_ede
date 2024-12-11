package com.example.appede.presentation.home.login

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appede.ui.theme.AppEDETheme
import com.example.appede.R
import com.example.appede.data.local.AppDatabase
import com.example.appede.data.repository.UserRepository
import com.example.appede.presentation.viewmodel.LoginState
import com.example.appede.presentation.viewmodel.SessionViewModel
import com.example.appede.presentation.viewmodel.SessionViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

@Composable
fun LoginForm(
    modifier: Modifier = Modifier,
    onLoginSuccess: (Int) -> Unit
) {
    val TAG = "LoginForm"

    val context = LocalContext.current
    val database = remember { AppDatabase.getDatabase(context, CoroutineScope(Dispatchers.IO)) }
    val userRepository = remember { UserRepository(database.userDao()) }

    val sessionViewModel: SessionViewModel = viewModel(
        factory = SessionViewModelFactory(userRepository)
    )

    // Estado de la base de datos
    val isDatabaseReady = remember { MutableStateFlow(true) }.collectAsState(initial = true).value

    var showErrorDialog by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    var cedula: String by remember { mutableStateOf("") }
    var pwd: String by remember { mutableStateOf("") }

    val loginState by sessionViewModel.loginState.collectAsState()

    LaunchedEffect(loginState) {
        Log.d(TAG, "Estado de login actualizado: $loginState")
        when (loginState) {
            is LoginState.Success -> {
                val userId = (loginState as LoginState.Success).userId
                Log.d("LoginForm", "Recibido userId=$userId tras login exitoso.")
                onLoginSuccess(userId)
                sessionViewModel.logout()
            }
            is LoginState.Error -> {
                errorMessage = (loginState as LoginState.Error).message
                showErrorDialog = true
                Log.e(TAG, "Error de login: $errorMessage")
            }
            is LoginState.Loading -> {
                Log.d(TAG, "Procesando login...")
            }
            else -> {}
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 5.dp, bottom = 120.dp, start = 30.dp, end = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "INICIAR SESIÓN",
            style = TextStyle(
                color = Color(0xFF002F5D),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Image(
            painter = painterResource(id = R.drawable.dgrd),
            contentDescription = "Logo DGRD",
            modifier = Modifier
                .size(150.dp)
                .padding(8.dp)
        )
        Text(
            text = "Aplicación para la Evaluación de Daños en Edificaciones",
            style = TextStyle(
                color = Color(0xFF002F5D),
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = cedula,
            onValueChange = { cedula = it },
            label = { Text("Cédula") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(2.dp))
        OutlinedTextField(
            value = pwd,
            onValueChange = { pwd = it },
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(1.dp))
        Text(
            text = "¿Olvidaste la contraseña?",
            color = Color(0xFF002F5D),
            modifier = Modifier
                .padding(1.dp)
                .clickable(onClick = { /*TODO*/ })
        )

        Button(
            onClick = {
                if (cedula.isNotEmpty() && pwd.isNotEmpty()) {
                    val personaId = cedula.toIntOrNull()
                    if (personaId != null) {
                        sessionViewModel.login(personaId, pwd)
                    } else {
                        errorMessage = "Cédula inválida"
                        showErrorDialog = true
                    }
                } else {
                    errorMessage = "Cédula y contraseña son requeridos"
                    showErrorDialog = true
                }
            },
            enabled = isDatabaseReady, // Deshabilita el botón si la base de datos no está lista
            colors = ButtonDefaults.buttonColors(
                Color(0xFAD502)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .height(50.dp)
        ) {
            Text(
                text = if (isDatabaseReady) "INGRESAR" else "CARGANDO...",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }
    }

    if (showErrorDialog) {
        AlertDialog(
            onDismissRequest = { showErrorDialog = false },
            title = { Text("Error de Credenciales") },
            text = { Text(errorMessage) },
            confirmButton = {
                Button(
                    onClick = { showErrorDialog = false }
                ) {
                    Text("Aceptar")
                }
            }
        )
    }
}

@Preview(
    showBackground = true,
)
@Composable
fun LoginScreenPreview() {
    AppEDETheme {
        LoginForm (
            onLoginSuccess = {}
        )
    }
}
