package com.example.appede.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Index

@Entity(
    tableName = "structural_system",
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
data class StructuralSystem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val evaluationId: Int,
    @ColumnInfo(name = "sistema_estructural") val sistemaEstructural: String,
    @ColumnInfo(name = "material") val material: String,
    @ColumnInfo(name = "sistema_entrepiso") val sistemaEntrepiso: String,
    @ColumnInfo(name = "material_entrepiso") val materialEntrepiso: String,
    @ColumnInfo(name = "sistema_soporte") val sistemaSoporte: String,
    @ColumnInfo(name = "revestimiento") val revestimiento: String,
    @ColumnInfo(name = "muros_divisores") val murosDivisores: String,
    @ColumnInfo(name = "fachadas") val fachadas: String,
    @ColumnInfo(name = "escaleras") val escaleras: String,
    @ColumnInfo(name = "nivel_diseno") val nivelDiseno: String,
    @ColumnInfo(name = "calidad_diseno") val calidadDiseno: String,
    @ColumnInfo(name = "estado_edificacion") val estadoEdificacion: String
)
