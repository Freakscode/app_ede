package com.example.appede.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
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
    ]
)
data class Evaluaciones(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "usuario_id") @NonNull val usuarioId: Int,
    @ColumnInfo(name = "fecha") val fecha: String,
    @ColumnInfo(name = "hora") val hora: String,
    @ColumnInfo(name = "id_grupo") val idGrupo: Int,
    @ColumnInfo(name = "tipo_evaluacion") val tipoEvaluacion: String,
    @ColumnInfo(name = "nombre_personas_cont") val nombrePersonasCont: String,
    @ColumnInfo(name = "email_persona_cont") val emailPersonaCont: String,
    @ColumnInfo(name = "cel_persona_cont") val celPersonaCont: String,
    @ColumnInfo(name = "responsable_persona_cont") val responsablePersonaCont: String,
    @ColumnInfo(name = "porcentaje_afectacion") val porcentajeAfectacion: String,
    @ColumnInfo(name = "severidad_danios") val severidadDanios: String,
    @ColumnInfo(name = "nivel_danio") val nivelDanio: String,
    @ColumnInfo(name = "habitabilidad") val habitabilidad: String,
    @ColumnInfo(name = "evaluacion_adicional") val evaluacionAdicional: String,
    @ColumnInfo(name = "recomendaciones_medidas") val recomendacionesMedidas: String,
    @ColumnInfo(name = "descripciones_generales") val descripcionesGenerales: String,
    // Campos de ubicación
    @ColumnInfo(name = "nombre_edificacion") val nombreEdificacion: String,
    @ColumnInfo(name = "municipio") val municipioId: String,
    @ColumnInfo(name = "barrio") val barrioId: String,
    @ColumnInfo(name = "num_via") val numVia: String,
    @ColumnInfo(name = "ap_via") val apVia: String,
    @ColumnInfo(name = "orientacion_via") val orientacionVia: String,
    @ColumnInfo(name = "num_cruce") val numCruce: String,
    @ColumnInfo(name = "orientacion_cruce") val orientacionCruce: String,
    @ColumnInfo(name = "complemento") val complemento: String,
    @ColumnInfo(name = "catastro") val catastro: String,
    @ColumnInfo(name = "lat") val lat: String,
    @ColumnInfo(name = "lon") val lon: String,
    @ColumnInfo(name = "tipo_propiedad") val tipoPropiedad: String,
    // Campos de características de edificación
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
    @ColumnInfo(name = "fecha_definicion_construccion") val fechaDefinicionConstruccion: String,
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
    @ColumnInfo(name = "estado_edificacion") val estadoEdificacion: String,
    // Riesgos y daños
    @ColumnInfo(name = "riesgo_externo") val riesgoExterno: String,
    @ColumnInfo(name = "compromete_acceso") val comprometeAcceso: String,
    @ColumnInfo(name = "compromete_estabilidad") val comprometeEstabilidad: String,
    @ColumnInfo(name = "danios") val danios: String
)

