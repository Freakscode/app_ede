package com.example.appede

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.appede.data.local.AppDatabase
import com.example.appede.data.local.entity.User
import com.example.appede.ui.components.HelloWorld
import com.example.appede.ui.theme.AppEDETheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppEDETheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HelloWorld(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

        //Room
        val database =
            Room.databaseBuilder(this, AppDatabase::class.java, "db_appede")
                .build()

        lifecycleScope.launch {
            database.daoUser.insert(
                User(
                    personaId = 123,
                    email = "email",
                    password = "password",
                    id = 1,
                    status = true,
                    role = ""
                )
            )
            database.daoUser.insert(
                User(
                    personaId = 1234,
                    email = "email",
                    password = "password",
                    id = 2,
                    status = true,
                    role = ""
                )
            )

            var usuarios = database.daoUser.getUserByIdiPersona(123)
            println(usuarios)

        }


    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppEDETheme {
        Greeting("Android")
    }
}

