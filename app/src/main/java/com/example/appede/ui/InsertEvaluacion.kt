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
    var userId by remember { mutableStateOf("") }
    var idGrupo by remember { mutableStateOf( 0) }
    var tipoEvaluacion by remember { mutableStateOf("") }
    var nombrePersonasCont by remember { mutableStateOf("") }
    var emailPersonaCont by remember { mutableStateOf("") }
    var celPersonaCont by remember { mutableStateOf("") }
    var responsablePersonaCont by remember { mutableStateOf("") }
    var porcentajeAfectacion by remember { mutableStateOf("") }
    var severidadDanios by remember { mutableStateOf("") }
    var nivelDanio by remember { mutableStateOf("") }
    var habitabilidad by remember { mutableStateOf( "") }
    var evaluacionAdicional by remember { mutableStateOf("") }
    var recomendacionesMedidas by remember { mutableStateOf("") }
    var descripcionesGenerales by remember { mutableStateOf("") }
    var nombreEdificacion by remember { mutableStateOf("") }
    var municipioId by remember { mutableStateOf("") }
    var barrioId by remember { mutableStateOf("") }
    var numVia by remember { mutableStateOf("") }
    var apVia by remember { mutableStateOf("") }
    var orientacionVia by remember { mutableStateOf( "") }
    var numCruce by remember { mutableStateOf("") }
    var orientacionCruce by remember { mutableStateOf("") }
    var complemento by remember { mutableStateOf("") }
    var catastro by remember { mutableStateOf("") }
    var lat by remember { mutableStateOf("") }
    var lon by remember { mutableStateOf("") }
    var tipoPropiedad by remember { mutableStateOf("") }
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
    var usoEdificacion by remember { mutableStateOf("") }
    var fechaDefinicionConstruccion by remember { mutableStateOf("") }
    var sistemaEstructural by remember { mutableStateOf("") }
    var material by remember { mutableStateOf("") }
    var sistemaEntrepiso by remember { mutableStateOf("") }
    var materialEntrepiso by remember { mutableStateOf("") }
    var sistemaSoporte by remember { mutableStateOf("") }
    var revestimiento by remember { mutableStateOf("") }
    var murosDivisores by remember { mutableStateOf("") }
    var fachadas by remember { mutableStateOf("") }
    var escaleras by remember { mutableStateOf("") }
    var nivelDiseno by remember { mutableStateOf("") }
    var calidadDiseno by remember { mutableStateOf("") }
    var estadoEdificacion by remember { mutableStateOf("") }
    var riesgoExterno by remember { mutableStateOf("") }
    var comprometeAcceso by remember { mutableStateOf("") }
    var comprometeEstabilidad by remember { mutableStateOf("") }
    var danios by remember { mutableStateOf("") }

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
                    nombrePersonasCont = nombrePersonasCont,
                    emailPersonaCont = emailPersonaCont,
                    celPersonaCont = celPersonaCont,
                    responsablePersonaCont = responsablePersonaCont,
                    porcentajeAfectacion = porcentajeAfectacion,
                    severidadDanios = severidadDanios,
                    nivelDanio = nivelDanio,
                    habitabilidad = habitabilidad,
                    evaluacionAdicional = evaluacionAdicional,
                    recomendacionesMedidas = recomendacionesMedidas,
                    descripcionesGenerales = descripcionesGenerales,
                    nombreEdificacion = nombreEdificacion,
                    municipioId = municipioId,
                    barrioId = barrioId,
                    numVia = numVia,
                    apVia = apVia,
                    orientacionVia = orientacionVia,
                    numCruce = numCruce,
                    orientacionCruce = orientacionCruce,
                    complemento = complemento,
                    catastro = catastro,
                    lat = lat,
                    lon = lon,
                    tipoPropiedad = tipoPropiedad,
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
                    riesgoExterno = riesgoExterno,
                    comprometeAcceso = comprometeAcceso,
                    comprometeEstabilidad = comprometeEstabilidad,
                    danios = danios
                )
                viewModel.insertEvaluacion(newEvaluacion)
            }) {
                Text("Guardar")
            }
        }
    }
}
