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

    // 2. Identificación de la edificación
        // Datos generales
    @ColumnInfo(name = "nombre_edificacion") val nombreEdificacion: String,
    @ColumnInfo(name = "municipio") val municipioId: String,
    @ColumnInfo(name = "barrio") val barrioId: String,
    @ColumnInfo(name = "tipo_via") val tipoVia: String,
    @ColumnInfo(name = "num_via") val numVia: String,
    @ColumnInfo(name = "ap_via") val apVia: String,
    @ColumnInfo(name = "orientacion_via") val orientacionVia: String,
    @ColumnInfo(name = "num_cruce") val numCruce: String,
    @ColumnInfo(name = "ap_cruce") val apCruce: String,
    @ColumnInfo(name = "orientacion_cruce") val orientacionCruce: String,
    @ColumnInfo(name = "numero") val numero: String,
    @ColumnInfo(name = "complemento") val complemento: String,
    @ColumnInfo(name = "tipo_propiedad") val tipoPropiedad: String,
        // Identificación catastral
    @ColumnInfo(name = "catastro") val catastro: String,
    @ColumnInfo(name = "lat") val lat: String,
    @ColumnInfo(name = "lon") val lon: String,
        // Persona de contacto
    @ColumnInfo(name = "nombre_personas_cont") val nombrePersonasCont: String,
    @ColumnInfo(name = "email_persona_cont") val emailPersonaCont: String,
    @ColumnInfo(name = "cel_persona_cont") val celPersonaCont: String,
    @ColumnInfo(name = "responsable_persona_cont") val responsablePersonaCont: String,

    // 3. Descripción de la edificación
        // Características generales
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
        // Usos predominantes
    @ColumnInfo(name = "uso_edificacion") val usoEdificacion: String,
    @ColumnInfo(name = "fecha_definicion_construccion") val fechaDefinicionConstruccion: String,
        // Sistema estructural y material
    @ColumnInfo(name = "sistema_estructural") val sistemaEstructural: String,
    @ColumnInfo(name = "material") val material: String,
        // Sistema de entrepiso
    @ColumnInfo(name = "sistema_entrepiso") val sistemaEntrepiso: String,
    @ColumnInfo(name = "material_entrepiso") val materialEntrepiso: String,
        // Sistemas de cubierta (Soporte, revestimiento)
    @ColumnInfo(name = "sistema_soporte") val sistemaSoporte: String,
    @ColumnInfo(name = "revestimiento") val revestimiento: String,
        // Elementos no estructurados adicionales
    @ColumnInfo(name = "muros_divisores") val murosDivisores: String,
    @ColumnInfo(name = "fachadas") val fachadas: String,
    @ColumnInfo(name = "escaleras") val escaleras: String,
        // Nivel de diseño
    @ColumnInfo(name = "nivel_diseno") val nivelDiseno: String,
    @ColumnInfo(name = "calidad_diseno") val calidadDiseno: String,
    @ColumnInfo(name = "estado_edificacion") val estadoEdificacion: String,

    // 4. Identificación de Riesgos
        // Riesgo externo
    @ColumnInfo(name = "caida_objetos") val caida_objetos: String,
    @ColumnInfo(name = "colapso_edificio_adyacentes") val colapso_edificio_adyacentes: String,
    @ColumnInfo(name = "falla_sistema_servicios") val falla_sistema_servicios: String,
    @ColumnInfo(name = "inestabilidad_terreno") val inestabilidad_terreno: String,
    @ColumnInfo(name = "acceso_salida") val acceso_salida: String,
    @ColumnInfo(name = "otro_riesgo_externo") val otro_riesgo_externo: String,
        // Compromete acceso
    @ColumnInfo(name = "acceso_caida_objetos") val compromete_caida_objetos: String,
    @ColumnInfo(name = "acceso_colapso_edificio_adyacentes") val compromete_colapso_edificio_adyacentes: String,
    @ColumnInfo(name = "acceso_falla_sistema_servicios") val compromete_falla_sistema_servicios: String,
    @ColumnInfo(name = "acceso_inestabilidad_terreno") val compromete_inestabilidad_terreno: String,
    @ColumnInfo(name = "acceso_acceso_salida") val compromete_acceso_salida: String,
    @ColumnInfo(name = "acceso_otro_riesgo_externo") val compromete_otro_riesgo_externo: String,
        // Compromete estabilidad
    @ColumnInfo(name = "estabilidad_caida_objetos") val estabilidad_caida_objetos: String,
    @ColumnInfo(name = "estabilidad_colapso_edificio_adyacentes") val estabilidad_colapso_edificio_adyacentes: String,
    @ColumnInfo(name = "estabilidad_falla_sistema_servicios") val estabilidad_falla_sistema_servicios: String,
    @ColumnInfo(name = "estabilidad_inestabilidad_terreno") val estabilidad_inestabilidad_terreno: String,
    @ColumnInfo(name = "estabilidad_acceso_salida") val estabilidad_acceso_salida: String,
    @ColumnInfo(name = "estabilidad_otro_riesgo_externo") val estabilidad_otro_riesgo_externo: String,

    // 5. Evaluación Daños
    @ColumnInfo(name = "colapso_total") val colapso_total: String,
    @ColumnInfo(name = "colapso_parcial") val colapso_parcial: String,
    @ColumnInfo(name = "asentamiento_elem_estructurales") val asentamiento_elem_estructurales: String,
    @ColumnInfo(name = "inclinacion_edificacion") val inclinacion_edificacion: String,
    @ColumnInfo(name = "inestabilidad_suelo") val inestabilidad_suelo: String,
    @ColumnInfo(name = "riesgo_caida_edificacion") val riesgo_caida_edificacion: String,
    @ColumnInfo(name = "danio_muros_carga") val danio_muros_carga: String,
    @ColumnInfo(name = "danio_sistemas_contrapiso") val danio_sistemas_contrapiso: String,
    @ColumnInfo(name = "cubierta") val cubierta: String,
    @ColumnInfo(name = "cielo_rasos") val cielo_rasos: String,
    @ColumnInfo(name = "alcance_evaluacion_ext") val alcance_evaluacion_ext: String,
    @ColumnInfo(name = "alcance_evaluacion_int") val alcance_evaluacion_int: String,

    // 6. Nivel Daño
    @ColumnInfo(name = "porcentaje_afectacion") val porcentajeAfectacion: String,
    @ColumnInfo(name = "severidad_danios") val severidadDanios: String,
    @ColumnInfo(name = "nivel_danio") val nivelDanio: String,

    // 7. Habitabilidad
    @ColumnInfo(name = "habitabilidad") val habitabilidad: String,

    // 8. Acciones recomendadas
    @ColumnInfo(name = "evaluacion_adicional") val evaluacionAdicional: String,
    @ColumnInfo(name = "recomendaciones_medidas") val recomendacionesMedidas: String,
    @ColumnInfo(name = "descripciones_generales") val descripcionesGenerales: String
)

