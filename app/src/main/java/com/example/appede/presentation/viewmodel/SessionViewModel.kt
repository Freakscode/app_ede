package com.example.appede.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appede.data.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

sealed class LoginState {
    object Idle : LoginState()
    object Loading : LoginState()
    data class Success(val userId: Int) : LoginState()
    data class Error(val message: String) : LoginState()
}

class SessionViewModel(private val userRepository: UserRepository) : ViewModel() {
    private val TAG = "SessionViewModel"
    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState: StateFlow<LoginState> = _loginState

    fun login(personaID: Int, password: String) {
        viewModelScope.launch {
            _loginState.value = LoginState.Loading
            try {
                val isValid = withContext(Dispatchers.IO) {
                    userRepository.isValidUser(personaID, password)
                }

                if (isValid) {
                    val user = withContext(Dispatchers.IO) {
                        userRepository.getUserByPersonaId(personaID)
                    }

                    if (user != null) {
                        Log.d(TAG, "Login exitoso: personaId=$personaID → userId=${user.id}")
                        _loginState.value = LoginState.Success(user.id)
                    } else {
                        Log.e(TAG, "No se pudo obtener el User completo tras login exitoso. personaId=$personaID")
                        _loginState.value = LoginState.Error("No se pudo obtener el usuario")
                    }
                } else {
                    Log.w(TAG, "Credenciales inválidas para personaId=$personaID")
                    _loginState.value = LoginState.Error("Credenciales inválidas")
                }
            } catch (e: Exception) {
                _loginState.value = LoginState.Error("Error inesperado: ${e.localizedMessage}")
            }
        }
    }

    fun logout() {
        _loginState.value = LoginState.Idle
    }
}
