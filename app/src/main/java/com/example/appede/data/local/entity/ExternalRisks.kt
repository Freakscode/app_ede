package com.example.appede.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Index


@Entity(
    tableName = "external_risks",
    foreignKeys = [
        ForeignKey(
            entity = Evaluaciones::class,
            parentColumns = ["id"],
            childColumns = ["evaluationId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["evaluationId"])]
)
data class ExternalRisks(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val evaluationId: Int,
    @ColumnInfo(name = "riesgo_externo") val riesgoExterno: String,
    @ColumnInfo(name = "compromete_acceso") val comprometeAcceso: String,
    @ColumnInfo(name = "compromete_estabilidad") val comprometeEstabilidad: String
)
