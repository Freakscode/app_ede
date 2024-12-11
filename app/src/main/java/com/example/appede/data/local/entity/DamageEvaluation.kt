package com.example.appede.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Index

@Entity(
    tableName = "damage_evaluation",
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
data class DamageEvaluation(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val evaluationId: Int,
    @ColumnInfo(name = "porcentaje_afectacion") val porcentajeAfectacion: String,
    @ColumnInfo(name = "severidad_danios") val severidadDanios: String,
    @ColumnInfo(name = "nivel_danio") val nivelDanio: String,
    @ColumnInfo(name = "habitabilidad") val habitabilidad: String,
    @ColumnInfo(name = "danios") val danios: String,
    @ColumnInfo(name = "evaluacion_adicional") val evaluacionAdicional: String?, // Cambiado a nullable
    @ColumnInfo(name = "recomendaciones_medidas") val recomendacionesMedidas: String?, // Cambiado a nullable
    @ColumnInfo(name = "descripciones_generales") val descripcionesGenerales: String
)
