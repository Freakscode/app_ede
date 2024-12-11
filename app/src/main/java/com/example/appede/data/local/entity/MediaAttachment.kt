package com.example.appede.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Index

@Entity(
    tableName = "media_attachments",
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
data class MediaAttachment(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val evaluationId: Int,
    val sectionName: String,
    val mediaType: String, // "AUDIO"
    val fileUri: String,
    val timestamp: Long = System.currentTimeMillis()
)
