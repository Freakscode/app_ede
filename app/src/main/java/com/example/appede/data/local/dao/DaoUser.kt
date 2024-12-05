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
    suspend fun isValidUser(personaID: String, psd: String): Boolean

    @Query("SELECT * FROM user_table")
    suspend fun getAllUsers(): List<User>

}