package com.example.appede

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.example.appede.data.local.AppDatabase
import com.example.appede.data.local.Database
import com.example.appede.navigation.AppNavGraph
import com.example.appede.ui.theme.AppEDETheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "MainActivity started")

        val db = AppDatabase.getDatabase(this, lifecycleScope)
        Log.d("MainActivity", "Database initialized")

        setContent {
            AppEDETheme {
                val navController = rememberNavController()
                Log.d("MainActivity", "NavController initialized")
                AppNavGraph(
                    navController = navController,
                    database = db
                )
            }
        }
    }
}
