package com.example.appede.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Index

@Entity(
    tableName = "comments",
    foreignKeys = [
        ForeignKey(
            entity = Evaluaciones::class,
            parentColumns = ["id"],
            childColumns = ["evaluationId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["evaluationId", "sectionName"])]
)
data class Comment(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val evaluationId: Int,
    val sectionName: String,
    val commentText: String,
    val timestamp: Long = System.currentTimeMillis(),
    val audioPath: String? = null
)
