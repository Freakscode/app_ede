package com.example.appede

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.appede.presentation.home.login.HomeScreen
import com.example.appede.ui.theme.AppEDETheme
import com.example.appede.presentation.home.login.LoginForm

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppEDETheme {
                HomeScreen()
            }
        }
    }
}
