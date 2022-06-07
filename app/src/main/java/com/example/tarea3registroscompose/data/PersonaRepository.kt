package com.example.tarea3registroscompose.data

import com.example.tarea3registroscompose.model.Persona
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PersonaRepository @Inject constructor(
    val personaDao: PersonaDao
) {
    suspend fun insertar(persona: Persona){
        personaDao.insertar(persona)
    }

    suspend fun eliminar(persona: Persona){
        personaDao.eliminar(persona)
    }

    fun buscar(personaId: Int): Flow<List<Persona>> {
        return personaDao.buscar(personaId)
    }

    fun getLista(): Flow<List<Persona>> {
        return personaDao.getLista()
    }
}