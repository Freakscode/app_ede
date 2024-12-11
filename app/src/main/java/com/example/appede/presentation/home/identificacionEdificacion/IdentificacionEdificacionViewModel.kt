package com.example.appede.presentation.home.identificacionEdificacion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appede.data.local.entity.BuildingIdentification
import com.example.appede.data.repository.BuildingIdentificationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class IdentificacionEdificacionViewModel(
    private val repository: BuildingIdentificationRepository,
    private val evaluationId: Int
) : ViewModel() {

    private val _state = MutableStateFlow<BuildingIdentification?>(null)
    val state: StateFlow<BuildingIdentification?> = _state

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            _state.value = repository.getBuildingIdentification(evaluationId)
        }
    }

    // Función para actualizar los datos generales
    fun updateDatosGenerales(
        nombreEdificacion: String,
        municipio: String,
        barrio: String,
        tipoPropiedad: String
    ) {
        val current = _state.value
        if (current != null) {
            _state.value = current.copy(
                nombreEdificacion = nombreEdificacion,
                municipio = municipio,
                barrio = barrio,
                tipoPropiedad = tipoPropiedad
            )
        } else {
            _state.value = BuildingIdentification(
                evaluationId = evaluationId,
                nombreEdificacion = nombreEdificacion,
                municipio = municipio,
                barrio = barrio,
                tipoPropiedad = tipoPropiedad,
                numVia = "",
                apVia = "",
                orientacionVia = "",
                numCruce = "",
                orientacionCruce = "",
                complemento = "",
                catastro = "",
                lat = "",
                lon = ""
            )
        }
    }

    // Función para guardar los datos generales
    fun saveDatosGenerales() {
        viewModelScope.launch {
            _state.value?.let { data ->
                repository.saveBuildingIdentification(data)
            }
        }
    }

    // Función para actualizar Catastro y Localización
    fun updateCatastralLocalizacion(catastro: String, lat: String, lon: String) {
        val current = _state.value
        if (current != null) {
            _state.value = current.copy(
                catastro = catastro,
                lat = lat,
                lon = lon
            )
        } else {
            _state.value = BuildingIdentification(
                evaluationId = evaluationId,
                catastro = catastro,
                lat = lat,
                lon = lon,
                nombreEdificacion = "",
                municipio = "",
                barrio = "",
                tipoPropiedad = "",
                numVia = "",
                apVia = "",
                orientacionVia = "",
                numCruce = "",
                orientacionCruce = "",
                complemento = ""
            )
        }
    }

    // Función para guardar Catastro y Localización
    fun saveCatastralLocalizacion() {
        viewModelScope.launch {
            _state.value?.let { data ->
                repository.saveBuildingIdentification(data)
            }
        }
    }

    // Función para actualizar la sección "Persona de Contacto"
    fun updatePersonaContacto(
        nombrePersonasCont: String,
        emailPersonaCont: String,
        celPersonaCont: String,
        responsablePersonaCont: String
    ) {
        val current = _state.value
        if (current != null) {
            _state.value = current.copy(
                nombrePersonasCont = nombrePersonasCont,
                emailPersonaCont = emailPersonaCont,
                celPersonaCont = celPersonaCont,
                responsablePersonaCont = responsablePersonaCont
            )
        } else {
            _state.value = BuildingIdentification(
                evaluationId = evaluationId,
                nombrePersonasCont = nombrePersonasCont,
                emailPersonaCont = emailPersonaCont,
                celPersonaCont = celPersonaCont,
                responsablePersonaCont = responsablePersonaCont,
                nombreEdificacion = "",
                municipio = "",
                barrio = "",
                tipoPropiedad = "",
                numVia = "",
                apVia = "",
                orientacionVia = "",
                numCruce = "",
                orientacionCruce = "",
                complemento = "",
                catastro = "",
                lat = "",
                lon = ""
            )
        }
    }

    // Función para guardar los datos de "Persona de Contacto"
    fun savePersonaContacto() {
        viewModelScope.launch {
            _state.value?.let { data ->
                repository.saveBuildingIdentification(data)
            }
        }
    }
}

