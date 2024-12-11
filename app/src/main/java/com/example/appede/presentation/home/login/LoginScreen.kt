package com.example.appede.presentation.home.login

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.example.appede.presentation.home.FooterHome
import com.example.appede.ui.theme.AppEDETheme

@Composable
fun LoginScreen(
    onLoginSuccess: (Int) -> Unit = {}
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            HeaderHome()
            LoginForm(
                onLoginSuccess = { userId ->
                    Log.d("LoginScreen", "Navegando a Home con userId=$userId")
                    onLoginSuccess(userId)
                }
            )
        }
        FooterHome(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
@Preview(
    showBackground = true,
)
fun HomeScreenPreview() {
    AppEDETheme {
        LoginScreen()
    }
}

