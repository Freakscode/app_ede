package com.example.appede.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.appede.data.local.entity.User

@Dao
interface DaoUser {

    @Insert
    fun insert(user: User): Long

    @Query("SELECT * FROM user_table WHERE persona_id = :personaId")
    fun getUserByIdiPersona(personaId: Int): User?

}