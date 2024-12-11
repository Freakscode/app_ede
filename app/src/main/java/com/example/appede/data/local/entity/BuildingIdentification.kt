package com.example.appede.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Index

@Entity(
    tableName = "building_identification",
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
data class BuildingIdentification(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val evaluationId: Int,
    val nombreEdificacion: String,
    val municipio: String,
    val barrio: String,
    val numVia: String,
    val apVia: String,
    val orientacionVia: String,
    val numCruce: String,
    val orientacionCruce: String,
    val complemento: String,
    val catastro: String,
    val lat: String,
    val lon: String,
    val tipoPropiedad: String,
    val nombrePersonasCont: String = "",
    val emailPersonaCont: String = "",
    val celPersonaCont: String = "",
    val responsablePersonaCont: String = ""
)
