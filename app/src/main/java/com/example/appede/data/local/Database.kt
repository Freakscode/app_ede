package com.example.appede.data.local

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.appede.data.local.dao.BuildingDescriptionDao
import com.example.appede.data.local.dao.BuildingIdentificationDao
import com.example.appede.data.local.dao.CommentDao
import com.example.appede.data.local.dao.DamageEvaluationDao
import com.example.appede.data.local.dao.DaoEvaluaciones
import com.example.appede.data.local.dao.DaoUser
import com.example.appede.data.local.dao.ExternalRisksDao
import com.example.appede.data.local.dao.MediaAttachmentDao
import com.example.appede.data.local.dao.StructuralSystemDao
import com.example.appede.data.local.entity.BuildingIdentification
import com.example.appede.data.local.entity.BuildingDescription
import com.example.appede.data.local.entity.StructuralSystem
import com.example.appede.data.local.entity.ExternalRisks
import com.example.appede.data.local.entity.DamageEvaluation
import com.example.appede.data.local.entity.Comment
import com.example.appede.data.local.entity.MediaAttachment
import com.example.appede.data.local.entity.Evaluaciones
import com.example.appede.data.local.entity.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Database(
    entities = [
        BuildingDescription::class,
        BuildingIdentification::class,
        Comment::class,
        DamageEvaluation::class,
        Evaluaciones::class,
        ExternalRisks::class,
        MediaAttachment::class,
        StructuralSystem::class,
        User::class
    ],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun buildingDescriptionDao(): BuildingDescriptionDao
    abstract fun buildingIdentificationDao(): BuildingIdentificationDao
    abstract fun commentDao(): CommentDao
    abstract fun damageEvaluationDao(): DamageEvaluationDao
    abstract fun evaluacionesDao(): DaoEvaluaciones
    abstract fun externalRisksDao(): ExternalRisksDao
    abstract fun mediaAttachmentDao(): MediaAttachmentDao
    abstract fun structuralSystemDao(): StructuralSystemDao
    abstract fun userDao(): DaoUser

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .addCallback(DatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }

        private class DatabaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        try {
                            populateDatabase(database)
                            Log.d("AppDatabase", "Base de datos poblada correctamente")
                        } catch (e: Exception) {
                            Log.e("AppDatabase", "Error al poblar la base de datos", e)
                        }
                    }
                }
            }
        }

        suspend fun populateDatabase(database: AppDatabase) {
            Log.d("AppDatabase", "Inicio de la inserción de datos")
            val evaluacionesDao = database.evaluacionesDao()
            val buildingDescriptionDao = database.buildingDescriptionDao()
            val buildingIdentificationDao = database.buildingIdentificationDao()
            val damageEvaluationDao = database.damageEvaluationDao()
            val userDao = database.userDao()
            val externalRisksDao = database.externalRisksDao()
            val structuralSystemDao = database.structuralSystemDao()
            val commentDao = database.commentDao()
            val mediaAttachmentDao = database.mediaAttachmentDao()

            // Insertando Usuarios
            val user1 = User(personaId = 12304932, email = "user1@dgrd.com", password = "1234", role = "evaluador")
            val user2 = User(personaId = 12304933, email = "user2@dgrd.com", password = "1234", role = "evaluador")
            val user1Id = userDao.insert(user1)
            val user2Id = userDao.insert(user2)

            Log.d("AppDatabase", "Usuarios insertados con IDs: $user1Id, $user2Id")

            // Función para generar datos comunes a múltiples evaluaciones
            fun generateEvaluationData(evaluationId: Int, userId: Int, buildingIndex: Int): List<Any> {
                val buildingIdentification = BuildingIdentification(
                    evaluationId = evaluationId,
                    nombreEdificacion = "Edificio $buildingIndex",
                    municipio = "Municipio $buildingIndex",
                    barrio = "Barrio $buildingIndex",
                    numVia = "$buildingIndex",
                    apVia = "A$buildingIndex",
                    orientacionVia = "Sur",
                    numCruce = "$buildingIndex",
                    orientacionCruce = "Este",
                    complemento = "Complemento $buildingIndex",
                    catastro = "12345678$buildingIndex",
                    lat = "6.2$buildingIndex",
                    lon = "-75.5$buildingIndex",
                    tipoPropiedad = "Tipo $buildingIndex"
                )

                val buildingDescription = BuildingDescription(
                    evaluationId = evaluationId,
                    numPisos = 5 + buildingIndex,
                    sotanos = 1,
                    frente = 20.0 + buildingIndex,
                    fondo = 30.0 + buildingIndex,
                    numUnidadesResidenciales = 10,
                    numUnidadesComerciales = 2,
                    numUnidadesNoHab = 0,
                    numOcupantes = 50 + buildingIndex,
                    muertos = 0,
                    heridos = buildingIndex % 2,
                    acceso = "Acceso $buildingIndex",
                    usoEdificacion = "Residencial",
                    fechaDefinicionConstruccion = "Entre ${2000 + buildingIndex} y ${2010 + buildingIndex}"
                )

                val damageEvaluation = DamageEvaluation(
                    evaluationId = evaluationId,
                    porcentajeAfectacion = "${10 * buildingIndex}-${40 + (10 * buildingIndex)}%",
                    severidadDanios = if (buildingIndex % 2 == 0) "Medio" else "Alto",
                    nivelDanio = if (buildingIndex % 2 == 0) "Moderado" else "Severo",
                    habitabilidad = if (buildingIndex % 2 == 0) "Habitable" else "No habitable",
                    danios = "Daños $buildingIndex",
                    evaluacionAdicional = "Adicional $buildingIndex",
                    recomendacionesMedidas = "Medidas $buildingIndex",
                    descripcionesGenerales = "Descripción $buildingIndex"
                )

                val externalRisk = ExternalRisks(
                    evaluationId = evaluationId,
                    riesgoExterno = "Riesgo $buildingIndex",
                    comprometeAcceso = if (buildingIndex % 2 == 0) "No" else "Sí",
                    comprometeEstabilidad = if (buildingIndex % 2 == 0) "No" else "Sí"
                )

                val structuralSystem = StructuralSystem(
                    evaluationId = evaluationId,
                    sistemaEstructural = "Sistema $buildingIndex",
                    material = "Material $buildingIndex",
                    sistemaEntrepiso = "Entrepiso $buildingIndex",
                    materialEntrepiso = "Material Entrepiso $buildingIndex",
                    sistemaSoporte = "Soporte $buildingIndex",
                    revestimiento = "Revestimiento $buildingIndex",
                    murosDivisores = "Muros $buildingIndex",
                    fachadas = "Fachadas $buildingIndex",
                    escaleras = "Escaleras $buildingIndex",
                    nivelDiseno = "Nivel Diseño $buildingIndex",
                    calidadDiseno = "Calidad Diseño $buildingIndex",
                    estadoEdificacion = "Estado $buildingIndex"
                )

                val comment = Comment(
                    evaluationId = evaluationId,
                    sectionName = "General",
                    commentText = "Comentario $buildingIndex",
                    timestamp = System.currentTimeMillis()
                )

                val mediaAttachment = MediaAttachment(
                    evaluationId = evaluationId,
                    sectionName = "Evidencia",
                    mediaType = "Imagen",
                    fileUri = "media/images/evidence$buildingIndex.jpg",
                    timestamp = System.currentTimeMillis()
                )

                return listOf(
                    buildingIdentification,
                    buildingDescription,
                    damageEvaluation,
                    externalRisk,
                    structuralSystem,
                    comment,
                    mediaAttachment
                )
            }

            // Generar 5 evaluaciones por usuario
            for (userIndex in 1..2) {
                val userId = if (userIndex == 1) user1Id.toInt() else user2Id.toInt()
                for (evalIndex in 1..5) {
                    val evaluation = Evaluaciones(
                        usuarioId = userId,
                        fecha = "2024-12-${10 + evalIndex}",
                        hora = "10:00",
                        idGrupo = evalIndex,
                        tipoEvaluacion = if (evalIndex % 2 == 0) "Detallada" else "Rápida",
                        nombrePersonasCont = "Usuario $userIndex",
                        emailPersonaCont = "contacto$userIndex@example.com",
                        celPersonaCont = "12345${evalIndex}789",
                        responsablePersonaCont = "Responsable $evalIndex",
                        firmaPath = ""
                    )
                    val evalId = evaluacionesDao.insertEvaluacion(evaluation).toInt()

                    val data = generateEvaluationData(evalId, userId, evalIndex)

                    data.forEach {
                        when (it) {
                            is BuildingIdentification -> buildingIdentificationDao.insert(it)
                            is BuildingDescription -> buildingDescriptionDao.insertOrUpdate(it)
                            is DamageEvaluation -> damageEvaluationDao.insertOrUpdate(it)
                            is ExternalRisks -> externalRisksDao.insertOrUpdate(it)
                            is StructuralSystem -> structuralSystemDao.insertOrUpdate(it)
                            is Comment -> commentDao.insertComment(it)
                            is MediaAttachment -> mediaAttachmentDao.insertMedia(it)
                        }
                    }
                }
            }

            Log.d("AppDatabase", "Datos insertados para 5 evaluaciones por usuario.")
        }

    }
}
