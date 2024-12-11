package com.example.appede.presentation.home.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appede.data.local.entity.Evaluaciones
import com.example.appede.data.repository.EvaluacionesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class AddEvaluacionViewModel(
    private val repository: EvaluacionesRepository
) : ViewModel() {

    // Campos del formulario
    private val _nombreEvaluador = MutableStateFlow("")
    val nombreEvaluador: StateFlow<String> = _nombreEvaluador

    private val _idEvento = MutableStateFlow("")
    val idEvento: StateFlow<String> = _idEvento

    private val _idGrupo = MutableStateFlow("")
    val idGrupo: StateFlow<String> = _idGrupo

    private val _dependenciaEntidad = MutableStateFlow("")
    val dependenciaEntidad: StateFlow<String> = _dependenciaEntidad

    private val _firmaPath = MutableStateFlow("")
    val firmaPath: StateFlow<String> = _firmaPath

    private val _tipoEvaluacion = MutableStateFlow("Inicial")
    val tipoEvaluacion: StateFlow<String> = _tipoEvaluacion

    // StateFlow para mantener el ID de la evaluación
    private val _evaluationId = MutableStateFlow<Int?>(null)
    val evaluationId: StateFlow<Int?> = _evaluationId

    // Métodos para actualizar el estado
    fun onNombreEvaluadorChange(value: String) {
        _nombreEvaluador.value = value
    }

    fun onIdEventoChange(value: String) {
        _idEvento.value = value
    }

    fun onIdGrupoChange(value: String) {
        _idGrupo.value = value.filter { it.isDigit() }
    }

    fun onDependenciaEntidadChange(value: String) {
        _dependenciaEntidad.value = value
    }

    fun onFirmaPathChange(value: String) {
        _firmaPath.value = value
    }

    fun setTipoEvaluacion(tipo: String) {
        _tipoEvaluacion.value = tipo
    }

    // Función para guardar una evaluación y obtener su ID
    fun saveEvaluation(usuarioId: Int) {
        val idGrupoInt = _idGrupo.value.toIntOrNull() ?: 0
        val idEventoValue = if (_idEvento.value.isNotEmpty()) _idEvento.value.toInt() else 0 // Asumiendo que 0 es válido

        viewModelScope.launch {
            val nuevaEvaluacion = Evaluaciones(
                usuarioId = usuarioId,
                fecha = obtenerFechaActual(),
                hora = obtenerHoraActual(),
                idGrupo = idGrupoInt,
                tipoEvaluacion = tipoEvaluacion.value,
                nombrePersonasCont = nombreEvaluador.value,
                emailPersonaCont = "",
                celPersonaCont = "",
                responsablePersonaCont = "",
                firmaPath = firmaPath.value
            )
            val id = repository.insertEvaluacion(nuevaEvaluacion)
            _evaluationId.value = id.toInt() // Convertir Long a Int si es necesario
        }
    }

    private fun obtenerFechaActual() = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
    private fun obtenerHoraActual() = SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())
}
