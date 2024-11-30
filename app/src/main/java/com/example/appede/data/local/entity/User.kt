package com.example.appede.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "persona_id") @NonNull val personaId: Int,
    @ColumnInfo(name = "email") @NonNull val email: String,
    @ColumnInfo(name = "password") @NonNull val password: String,
    @ColumnInfo(name = "status") val status: Boolean,
    @ColumnInfo(name = "role") val role: String
)
