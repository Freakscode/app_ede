package com.example.appede.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appede.data.local.entity.BuildingIdentification
import com.example.appede.data.repository.BuildingIdentificationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

interface BuildingIdentificationViewModelInterface {
    val state: StateFlow<BuildingIdentification?>
    fun updateBuildingIdentification(
        nombreEdificacion: String,
        municipioId: String,
        barrioId: String,
        numVia: String,
        apVia: String,
        orientacionVia: String,
        numCruce: String,
        orientacionCruce: String,
        complemento: String,
        catastro: String,
        lat: String,
        lon: String,
        tipoPropiedad: String
    )

    fun saveBuildingIdentification()
}

class BuildingIdentificationViewModel(
    private val repository: BuildingIdentificationRepository,
    private val evaluationId: Int
) : ViewModel(), BuildingIdentificationViewModelInterface {

    private val _state = MutableStateFlow<BuildingIdentification?>(null)
    override val state: StateFlow<BuildingIdentification?> = _state

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            _state.value = repository.getBuildingIdentification(evaluationId)
        }
    }

    override fun updateBuildingIdentification(
        nombreEdificacion: String,
        municipioId: String,
        barrioId: String,
        numVia: String,
        apVia: String,
        orientacionVia: String,
        numCruce: String,
        orientacionCruce: String,
        complemento: String,
        catastro: String,
        lat: String,
        lon: String,
        tipoPropiedad: String
    ) {
        val updatedData = BuildingIdentification(
            id = _state.value?.id ?: 0,
            evaluationId = evaluationId,
            nombreEdificacion = nombreEdificacion,
            municipio = municipioId,
            barrio = barrioId,
            numVia = numVia,
            apVia = apVia,
            orientacionVia = orientacionVia,
            numCruce = numCruce,
            orientacionCruce = orientacionCruce,
            complemento = complemento,
            catastro = catastro,
            lat = lat,
            lon = lon,
            tipoPropiedad = tipoPropiedad
        )
        _state.value = updatedData
    }

    override fun saveBuildingIdentification() {
        viewModelScope.launch {
            _state.value?.let { updatedData ->
                repository.saveBuildingIdentification(updatedData)
            }
        }
    }
}

class FakeBuildingIdentificationViewModel : BuildingIdentificationViewModelInterface {
    private val _state = MutableStateFlow<BuildingIdentification?>(BuildingIdentification(
        id = 1,
        evaluationId = 123,
        nombreEdificacion = "Edificio Prueba",
        municipio = "Medellín",
        barrio = "El Poblado",
        numVia = "10",
        apVia = "A",
        orientacionVia = "Sur",
        numCruce = "5",
        orientacionCruce = "Oeste",
        complemento = "Apto 301",
        catastro = "123456789",
        lat = "6.2359",
        lon = "-75.5751",
        tipoPropiedad = "Propiedad Horizontal"
    ))
    override val state: StateFlow<BuildingIdentification?> = _state

    override fun updateBuildingIdentification(
        nombreEdificacion: String,
        municipioId: String,
        barrioId: String,
        numVia: String,
        apVia: String,
        orientacionVia: String,
        numCruce: String,
        orientacionCruce: String,
        complemento: String,
        catastro: String,
        lat: String,
        lon: String,
        tipoPropiedad: String
    ) {
        // Solo actualizamos el estado local en el Fake
        _state.value = BuildingIdentification(
            id = 1,
            evaluationId = 123,
            nombreEdificacion = nombreEdificacion,
            municipio = municipioId,
            barrio = barrioId,
            numVia = numVia,
            apVia = apVia,
            orientacionVia = orientacionVia,
            numCruce = numCruce,
            orientacionCruce = orientacionCruce,
            complemento = complemento,
            catastro = catastro,
            lat = lat,
            lon = lon,
            tipoPropiedad = tipoPropiedad
        )
    }

    override fun saveBuildingIdentification() {
        // No hacemos nada en el Fake, ya que no persiste en la base de datos
    }
}
