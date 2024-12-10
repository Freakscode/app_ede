package com.example.appede.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appede.data.local.entity.Evaluaciones
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import com.example.appede.data.local.ViewModel.AppViewModel

@Composable
fun EvaluacionForm(viewModel: AppViewModel) {

    var fecha by remember { mutableStateOf("") }
    var hora by remember { mutableStateOf("") }
    var idGrupo by remember { mutableStateOf(0) }
    var tipoEvaluacion by remember { mutableStateOf("") }

// 2. Identificación de la edificación
// Datos generales
    var nombreEdificacion by remember { mutableStateOf("") }
    var municipioId by remember { mutableStateOf("") }
    var barrioId by remember { mutableStateOf("") }
    var tipoVia by remember { mutableStateOf("") }
    var numVia by remember { mutableStateOf("") }
    var apVia by remember { mutableStateOf("") }
    var orientacionVia by remember { mutableStateOf("") }
    var numCruce by remember { mutableStateOf("") }
    var apCruce by remember { mutableStateOf("") }
    var orientacionCruce by remember { mutableStateOf("") }
    var numero by remember { mutableStateOf("") }
    var complemento by remember { mutableStateOf("") }
    var tipoPropiedad by remember { mutableStateOf("") }
// Identificación catastral
    var catastro by remember { mutableStateOf("") }
    var lat by remember { mutableStateOf("") }
    var lon by remember { mutableStateOf("") }
// Persona de contacto
    var nombrePersonasCont by remember { mutableStateOf("") }
    var emailPersonaCont by remember { mutableStateOf("") }
    var celPersonaCont by remember { mutableStateOf("") }
    var responsablePersonaCont by remember { mutableStateOf("") }

// 3. Descripción de la edificación
// Características generales
    var numPisos by remember { mutableStateOf(0) }
    var sotanos by remember { mutableStateOf(0) }
    var frente by remember { mutableStateOf(0.0) }
    var fondo by remember { mutableStateOf(0.0) }
    var numUnidadesResidenciales by remember { mutableStateOf(0) }
    var numUnidadesComerciales by remember { mutableStateOf(0) }
    var numUnidadesNoHab by remember { mutableStateOf(0) }
    var numOcupantes by remember { mutableStateOf(0) }
    var muertos by remember { mutableStateOf(0) }
    var heridos by remember { mutableStateOf(0) }
    var acceso by remember { mutableStateOf("") }
// Usos predominantes
    var usoEdificacion by remember { mutableStateOf("") }
    var fechaDefinicionConstruccion by remember { mutableStateOf("") }
// Sistema estructural y material
    var sistemaEstructural by remember { mutableStateOf("") }
    var material by remember { mutableStateOf("") }
// Sistema de entrepiso
    var sistemaEntrepiso by remember { mutableStateOf("") }
    var materialEntrepiso by remember { mutableStateOf("") }
// Sistemas de cubierta (Soporte, revestimiento)
    var sistemaSoporte by remember { mutableStateOf("") }
    var revestimiento by remember { mutableStateOf("") }
// Elementos no estructurados adicionales
    var murosDivisores by remember { mutableStateOf("") }
    var fachadas by remember { mutableStateOf("") }
    var escaleras by remember { mutableStateOf("") }
// Nivel de diseño
    var nivelDiseno by remember { mutableStateOf("") }
    var calidadDiseno by remember { mutableStateOf("") }
    var estadoEdificacion by remember { mutableStateOf("") }

// 4. Identificación de Riesgos
// Riesgo externo
    var caida_objetos by remember { mutableStateOf("") }
    var colapso_edificio_adyacentes by remember { mutableStateOf("") }
    var falla_sistema_servicios by remember { mutableStateOf("") }
    var inestabilidad_terreno by remember { mutableStateOf("") }
    var acceso_salida by remember { mutableStateOf("") }
    var otro_riesgo_externo by remember { mutableStateOf("") }
// Compromete acceso
    var compromete_caida_objetos by remember { mutableStateOf("") }
    var compromete_colapso_edificio_adyacentes by remember { mutableStateOf("") }
    var compromete_falla_sistema_servicios by remember { mutableStateOf("") }
    var compromete_inestabilidad_terreno by remember { mutableStateOf("") }
    var compromete_acceso_salida by remember { mutableStateOf("") }
    var compromete_otro_riesgo_externo by remember { mutableStateOf("") }
// Compromete estabilidad
    var estabilidad_caida_objetos by remember { mutableStateOf("") }
    var estabilidad_colapso_edificio_adyacentes by remember { mutableStateOf("") }
    var estabilidad_falla_sistema_servicios by remember { mutableStateOf("") }
    var estabilidad_inestabilidad_terreno by remember { mutableStateOf("") }
    var estabilidad_acceso_salida by remember { mutableStateOf("") }
    var estabilidad_otro_riesgo_externo by remember { mutableStateOf("") }

// 5. Evaluación Daños
    var colapso_total by remember { mutableStateOf("") }
    var colapso_parcial by remember { mutableStateOf("") }
    var asentamiento_elem_estructurales by remember { mutableStateOf("") }
    var inclinacion_edificacion by remember { mutableStateOf("") }
    var inestabilidad_suelo by remember { mutableStateOf("") }
    var riesgo_caida_edificacion by remember { mutableStateOf("") }
    var danio_muros_carga by remember { mutableStateOf("") }
    var danio_sistemas_contrapiso by remember { mutableStateOf("") }
    var cubierta by remember { mutableStateOf("") }
    var cielo_rasos by remember { mutableStateOf("") }
    var alcance_evaluacion_ext by remember { mutableStateOf("") }
    var alcance_evaluacion_int by remember { mutableStateOf("") }

// 6. Nivel Daño
    var porcentajeAfectacion by remember { mutableStateOf("") }
    var severidadDanios by remember { mutableStateOf("") }
    var nivelDanio by remember { mutableStateOf("") }

// 7. Habitabilidad
    var habitabilidad by remember { mutableStateOf("") }

// 8. Acciones recomendadas
    var evaluacionAdicional by remember { mutableStateOf("") }
    var recomendacionesMedidas by remember { mutableStateOf("") }
    var descripcionesGenerales by remember { mutableStateOf("") }


    Column(modifier = Modifier.padding(12.dp)) {
        Text("Formulario de Evaluación", fontWeight = FontWeight.Bold, fontSize = 20.sp)

        TextField(value = fecha, onValueChange = { fecha = it }, label = { Text("Fecha") }, modifier = Modifier.fillMaxWidth())
        TextField(value = hora, onValueChange = { hora = it }, label = { Text("Hora") }, modifier = Modifier.fillMaxWidth())
        TextField(value = tipoEvaluacion, onValueChange = { tipoEvaluacion = it }, label = { Text("Tipo Evaluación") }, modifier = Modifier.fillMaxWidth())
        TextField(value = nombrePersonasCont, onValueChange = { nombrePersonasCont = it }, label = { Text("Nombre Persona de Contacto") }, modifier = Modifier.fillMaxWidth())
        TextField(value = emailPersonaCont, onValueChange = { emailPersonaCont = it }, label = { Text("Email Persona de Contacto") }, modifier = Modifier.fillMaxWidth())
        TextField(value = porcentajeAfectacion, onValueChange = { porcentajeAfectacion = it }, label = { Text("Porcentaje de Afectación") }, modifier = Modifier.fillMaxWidth())
        // Los demás campos también se agregarían de manera similar...

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        ) {
            Button(onClick = {
                val newEvaluacion = Evaluaciones(
                usuarioId = 1,
                fecha = fecha,
                hora = hora,
                idGrupo = idGrupo,
                tipoEvaluacion = tipoEvaluacion,
                nombreEdificacion = nombreEdificacion,
                municipioId = municipioId,
                barrioId = barrioId,
                tipoVia = tipoVia,
                numVia = numVia,
                apVia = apVia,
                orientacionVia = orientacionVia,
                numCruce = numCruce,
                apCruce = apCruce,
                orientacionCruce = orientacionCruce,
                numero = numero,
                complemento = complemento,
                tipoPropiedad = tipoPropiedad,
                catastro = catastro,
                lat = lat,
                lon = lon,
                nombrePersonasCont = nombrePersonasCont,
                emailPersonaCont = emailPersonaCont,
                celPersonaCont = celPersonaCont,
                responsablePersonaCont = responsablePersonaCont,
                numPisos = numPisos,
                sotanos = sotanos,
                frente = frente,
                fondo = fondo,
                numUnidadesResidenciales = numUnidadesResidenciales,
                numUnidadesComerciales = numUnidadesComerciales,
                numUnidadesNoHab = numUnidadesNoHab,
                numOcupantes = numOcupantes,
                muertos = muertos,
                heridos = heridos,
                acceso = acceso,
                usoEdificacion = usoEdificacion,
                fechaDefinicionConstruccion = fechaDefinicionConstruccion,
                sistemaEstructural = sistemaEstructural,
                material = material,
                sistemaEntrepiso = sistemaEntrepiso,
                materialEntrepiso = materialEntrepiso,
                sistemaSoporte = sistemaSoporte,
                revestimiento = revestimiento,
                murosDivisores = murosDivisores,
                fachadas = fachadas,
                escaleras = escaleras,
                nivelDiseno = nivelDiseno,
                calidadDiseno = calidadDiseno,
                estadoEdificacion = estadoEdificacion,
                caida_objetos = caida_objetos,
                colapso_edificio_adyacentes = colapso_edificio_adyacentes,
                falla_sistema_servicios = falla_sistema_servicios,
                inestabilidad_terreno = inestabilidad_terreno,
                acceso_salida = acceso_salida,
                otro_riesgo_externo = otro_riesgo_externo,
                compromete_caida_objetos = compromete_caida_objetos,
                compromete_colapso_edificio_adyacentes = compromete_colapso_edificio_adyacentes,
                compromete_falla_sistema_servicios = compromete_falla_sistema_servicios,
                compromete_inestabilidad_terreno = compromete_inestabilidad_terreno,
                compromete_acceso_salida = compromete_acceso_salida,
                compromete_otro_riesgo_externo = compromete_otro_riesgo_externo,
                estabilidad_caida_objetos = estabilidad_caida_objetos,
                estabilidad_colapso_edificio_adyacentes = estabilidad_colapso_edificio_adyacentes,
                estabilidad_falla_sistema_servicios = estabilidad_falla_sistema_servicios,
                estabilidad_inestabilidad_terreno = estabilidad_inestabilidad_terreno,
                estabilidad_acceso_salida = estabilidad_acceso_salida,
                estabilidad_otro_riesgo_externo = estabilidad_otro_riesgo_externo,
                colapso_total = colapso_total,
                colapso_parcial = colapso_parcial,
                asentamiento_elem_estructurales = asentamiento_elem_estructurales,
                inclinacion_edificacion = inclinacion_edificacion,
                inestabilidad_suelo = inestabilidad_suelo,
                riesgo_caida_edificacion = riesgo_caida_edificacion,
                danio_muros_carga = danio_muros_carga,
                danio_sistemas_contrapiso = danio_sistemas_contrapiso,
                cubierta = cubierta,
                cielo_rasos = cielo_rasos,
                alcance_evaluacion_ext = alcance_evaluacion_ext,
                alcance_evaluacion_int = alcance_evaluacion_int,
                porcentajeAfectacion = porcentajeAfectacion,
                severidadDanios = severidadDanios,
                nivelDanio = nivelDanio,
                habitabilidad = habitabilidad,
                evaluacionAdicional = evaluacionAdicional,
                recomendacionesMedidas = recomendacionesMedidas,
                descripcionesGenerales = descripcionesGenerales
            )
                viewModel.insertEvaluacion(newEvaluacion)
            }) {
                Text("Guardar")
            }
        }
    }
}
