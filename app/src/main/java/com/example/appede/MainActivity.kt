package com.example.appede

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.room.Room
import com.example.appede.data.local.AppDatabase
import com.example.appede.data.local.entity.User

class MainActivity : ComponentActivity() {
    private lateinit var database: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        database = Room.databaseBuilder(
            application, AppDatabase::class.java, AppDatabase.DATABASE_NAME
        )
            .allowMainThreadQueries()
            .build()
        saveUsers()


        val btnUsuarios = findViewById<Button>(R.id.btnUsuarios)
        val usuarios = findViewById<TextView>(R.id.usuarios)
        btnUsuarios.setOnClickListener {
            val users = database.daoUser.getAllUsers()
            users.forEach { user ->
                usuarios.append("${user.id}, ${user.email}, ${user.password}, ${user.personaId}, ${user.status}, ${user.role}\n")
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
        database.daoUser.insert(user1)
        database.daoUser.insert(user2)

    }
}
