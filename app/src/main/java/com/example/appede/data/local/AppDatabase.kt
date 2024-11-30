package com.example.appede.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.appede.data.local.dao.DaoEvaluaciones
import com.example.appede.data.local.dao.DaoUser
import com.example.appede.data.local.entity.Evaluaciones
import com.example.appede.data.local.entity.User

@Database(entities = [Evaluaciones::class, User::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract val daoEvaluaciones: DaoEvaluaciones
    abstract val daoUser: DaoUser

    companion object {
        const val DATABASE_NAME = "db_appede"
    }
}