package com.example.appede.data.local

import android.content.Context
import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.appede.data.local.dao.DaoEvaluaciones
import com.example.appede.data.local.dao.DaoUser
import com.example.appede.data.local.entity.Evaluaciones
import com.example.appede.data.local.entity.User

@Database(entities = [Evaluaciones::class, User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val daoEvaluaciones: DaoEvaluaciones
    abstract val daoUser: DaoUser

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "db_ede"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                instance
            }
        }
    }
}
