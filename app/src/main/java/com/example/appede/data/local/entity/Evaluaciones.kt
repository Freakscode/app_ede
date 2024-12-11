package com.example.appede.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "evaluaciones_table",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["usuario_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["usuario_id"])]
)
data class Evaluaciones(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "usuario_id") val usuarioId: Int,
    @ColumnInfo(name = "fecha") val fecha: String,
    @ColumnInfo(name = "hora") val hora: String,
    @ColumnInfo(name = "id_grupo") val idGrupo: Int,
    @ColumnInfo(name = "tipo_evaluacion") val tipoEvaluacion: String,
    @ColumnInfo(name = "nombre_personas_cont") val nombrePersonasCont: String,
    @ColumnInfo(name = "email_persona_cont") val emailPersonaCont: String,
    @ColumnInfo(name = "cel_persona_cont") val celPersonaCont: String,
    @ColumnInfo(name = "responsable_persona_cont") val responsablePersonaCont: String,
    @ColumnInfo(name = "firma_path") val firmaPath: String
)

