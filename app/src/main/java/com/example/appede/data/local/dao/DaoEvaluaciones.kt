package com.example.appede.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.appede.data.local.entity.Evaluaciones

@Dao
interface DaoEvaluaciones {

    // Insertar una nueva evaluación
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEvaluacion(evaluacion: Evaluaciones): Long

    // Obtener una evaluación específica por su ID
    @Query("SELECT * FROM evaluaciones_table WHERE id = :id")
    suspend fun getEvaluacionById(id: Int): Evaluaciones?

    // Obtener todas las evaluaciones
    @Query("SELECT * FROM evaluaciones_table")
    suspend fun getAllEvaluaciones(): List<Evaluaciones>

    // Obtener evaluaciones por usuario (relación con el ID del usuario)
    @Query("SELECT * FROM evaluaciones_table WHERE usuario_id = :usuarioId")
    suspend fun getEvaluacionesByUsuario(usuarioId: Int): List<Evaluaciones>

    // Actualizar una evaluación
    @Update
    suspend fun updateEvaluacion(evaluacion: Evaluaciones): Int

    // Eliminar una evaluación específica
    @Delete
    suspend fun deleteEvaluacion(evaluacion: Evaluaciones)

    // Eliminar todas las evaluaciones
    @Query("DELETE FROM evaluaciones_table")
    suspend fun deleteAllEvaluaciones(): Int
}

