package com.example.appede.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class FullEvaluacion(
    @Embedded val evaluaciones: Evaluaciones,

    @Relation(
        parentColumn = "id",
        entityColumn = "evaluationId"
    )
    val buildingIdentification: BuildingIdentification?,

    @Relation(
        parentColumn = "id",
        entityColumn = "evaluationId"
    )
    val buildingDescription: BuildingDescription?,

    @Relation(
        parentColumn = "id",
        entityColumn = "evaluationId"
    )
    val structuralSystem: StructuralSystem?,

    @Relation(
        parentColumn = "id",
        entityColumn = "evaluationId"
    )
    val externalRisks: ExternalRisks?,

    @Relation(
        parentColumn = "id",
        entityColumn = "evaluationId"
    )
    val damageEvaluation: DamageEvaluation?,

    @Relation(
        parentColumn = "id",
        entityColumn = "evaluationId"
    )
    val comment: BuildingIdentification?,

    @Relation(
        parentColumn = "id",
        entityColumn = "evaluationId"
    )
    val mediaAttachment: BuildingIdentification?,

    )
