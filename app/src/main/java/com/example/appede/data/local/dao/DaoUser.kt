package com.example.appede.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.appede.data.local.entity.User

@Dao
interface DaoUser {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User): Long

    @Query("SELECT * FROM user_table")
    fun getAllUsers(): List<User>

}