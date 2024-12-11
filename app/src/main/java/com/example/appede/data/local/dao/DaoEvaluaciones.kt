package com.example.appede.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.appede.data.local.entity.Evaluaciones
import com.example.appede.data.local.entity.FullEvaluacion

@Dao
interface DaoEvaluaciones {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEvaluacion(evaluacion: Evaluaciones): Long

    @Query("SELECT * FROM evaluaciones_table WHERE id = :id")
    suspend fun getEvaluacionById(id: Int): Evaluaciones?

    @Query("SELECT * FROM evaluaciones_table")
    fun getAllEvaluaciones(): LiveData<List<Evaluaciones>>

    @Query("SELECT * FROM evaluaciones_table WHERE usuario_id = :usuarioId")
    suspend fun getEvaluacionesByUsuario(usuarioId: Int): List<Evaluaciones>


    @Delete
    suspend fun deleteEvaluacion(evaluacion: Evaluaciones)

    @Query("SELECT * FROM evaluaciones_table WHERE usuario_id = :usuarioId ORDER BY fecha DESC, hora DESC LIMIT 5")
    suspend fun getLastFiveEvaluaciones(usuarioId: Int): List<Evaluaciones>


    @Update
    suspend fun updateEvaluacion(evaluacion: Evaluaciones)
}
