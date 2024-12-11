package com.example.appede.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Index

@Entity(
    tableName = "building_description",
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
data class BuildingDescription(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val evaluationId: Int,
    @ColumnInfo(name = "num_pisos") val numPisos: Int,
    @ColumnInfo(name = "sotanos") val sotanos: Int,
    @ColumnInfo(name = "frente") val frente: Double,
    @ColumnInfo(name = "fondo") val fondo: Double,
    @ColumnInfo(name = "num_unidades_residenciales") val numUnidadesResidenciales: Int,
    @ColumnInfo(name = "num_unidades_comerciales") val numUnidadesComerciales: Int,
    @ColumnInfo(name = "num_unidades_no_hab") val numUnidadesNoHab: Int,
    @ColumnInfo(name = "num_ocupantes") val numOcupantes: Int,
    @ColumnInfo(name = "muertos") val muertos: Int,
    @ColumnInfo(name = "heridos") val heridos: Int,
    @ColumnInfo(name = "acceso") val acceso: String,
    @ColumnInfo(name = "uso_edificacion") val usoEdificacion: String,
    @ColumnInfo(name = "fecha_definicion_construccion") val fechaDefinicionConstruccion: String
)
