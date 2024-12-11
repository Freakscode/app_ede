package com.example.appede.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.appede.data.local.entity.User

@Dao
interface DaoUser {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User): Long

    @Query("SELECT COUNT(*) > 0 FROM user_table WHERE persona_id = :personaID AND password = :psd")
    suspend fun isValidUser(personaID: Int, psd: String): Boolean

    @Query("SELECT * FROM user_table WHERE id = :id")
    suspend fun getUserById(id: Int): User?

    @Query("SELECT * FROM user_table WHERE persona_id = :personaId LIMIT 1")
    suspend fun getUserByPersonaId(personaId: Int): User?
}