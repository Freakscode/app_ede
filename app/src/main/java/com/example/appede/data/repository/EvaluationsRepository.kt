package com.example.appede.data.repository

import androidx.lifecycle.LiveData
import com.example.appede.data.local.dao.*
import com.example.appede.data.local.entity.BuildingIdentification
import com.example.appede.data.local.entity.Evaluaciones
import com.example.appede.data.local.entity.FullEvaluacion

class EvaluacionesRepository(
    private val dao: DaoEvaluaciones,
    private val buildingIdentificationDao: BuildingIdentificationDao,
    private val buildingDescriptionDao: BuildingDescriptionDao,
    private val structuralSystemDao: StructuralSystemDao,
    private val externalRisksDao: ExternalRisksDao,
    private val damageEvaluationDao: DamageEvaluationDao,
    val commentDao: CommentDao,
    private val mediaAttachmentDao: MediaAttachmentDao
) {
    suspend fun insertEvaluacion(evaluacion: Evaluaciones): Long {
        return dao.insertEvaluacion(evaluacion)
    }

    suspend fun getLastFiveEvaluaciones(usuarioId: Int): List<Evaluaciones> {
        return dao.getLastFiveEvaluaciones(usuarioId)
    }

    suspend fun getEvaluacionesByUsuarioId(usuarioId: Int): List<Evaluaciones> {
        return dao.getEvaluacionesByUsuario(usuarioId)
    }

    fun getAllEvaluaciones(): LiveData<List<Evaluaciones>> {
        return dao.getAllEvaluaciones()
    }

    suspend fun getFullEvaluacionById(evaluationId: Int): FullEvaluacion? {
        val evaluacion = dao.getEvaluacionById(evaluationId) ?: return null
        val buildingIdentification = buildingIdentificationDao.getByEvaluationId(evaluationId)
        val buildingDescription = buildingDescriptionDao.getByEvaluationId(evaluationId)
        val structuralSystem = structuralSystemDao.getByEvaluationId(evaluationId)
        val externalRisks = externalRisksDao.getByEvaluationId(evaluationId)
        val damageEvaluation = damageEvaluationDao.getByEvaluationId(evaluationId)
        val comments = commentDao.getByEvaluationId(evaluationId)
        val mediaAttachments = mediaAttachmentDao.getByEvaluationId(evaluationId)

        return FullEvaluacion(
            evaluaciones = evaluacion,
            buildingIdentification = buildingIdentification,
            buildingDescription = buildingDescription,
            structuralSystem = structuralSystem,
            externalRisks = externalRisks,
            damageEvaluation = damageEvaluation,
            comment = comments,
            mediaAttachment = TODO()
        )
    }

    suspend fun getEvaluacionById(evaluationId: Int): Evaluaciones? {
        return dao.getEvaluacionById(evaluationId)
    }

    suspend fun updateEvaluacion(evaluacion: Evaluaciones) {
        dao.updateEvaluacion(evaluacion)
    }


    suspend fun updateBuildingIdentification(buildingIdentification: BuildingIdentification) {
        buildingIdentificationDao.update(buildingIdentification)
    }

    suspend fun deleteEvaluacion(evaluacion: Evaluaciones) {
        dao.deleteEvaluacion(evaluacion)
    }

    suspend fun getLastFiveFullEvaluaciones(usuarioId: Int): List<FullEvaluacion> {
        // Obtener las últimas 5 evaluaciones del usuario
        val evaluacionesList = dao.getLastFiveEvaluaciones(usuarioId)

        // Por cada evaluación, obtener las entidades relacionadas y formar un FullEvaluacion
        return evaluacionesList.map { evaluacion ->
            val buildingIdentification = buildingIdentificationDao.getByEvaluationId(evaluacion.id)
            val buildingDescription = buildingDescriptionDao.getByEvaluationId(evaluacion.id)
            val structuralSystem = structuralSystemDao.getByEvaluationId(evaluacion.id)
            val externalRisks = externalRisksDao.getByEvaluationId(evaluacion.id)
            val damageEvaluation = damageEvaluationDao.getByEvaluationId(evaluacion.id)
            val comments = commentDao.getByEvaluationId(evaluacion.id)
            val mediaAttachments = mediaAttachmentDao.getByEvaluationId(evaluacion.id)

            FullEvaluacion(
                evaluaciones = evaluacion,
                buildingIdentification = buildingIdentification,
                buildingDescription = buildingDescription,
                structuralSystem = structuralSystem,
                externalRisks = externalRisks,
                damageEvaluation = damageEvaluation,
                comment = comments,
                mediaAttachment = mediaAttachments
            )
        }
    }
}
