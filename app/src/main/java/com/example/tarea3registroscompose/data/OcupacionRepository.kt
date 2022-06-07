package com.example.tarea3registroscompose.data

import com.example.tarea3registroscompose.model.Ocupacion
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OcupacionRepository @Inject constructor(
    val ocupacionDao: OcupacionDao
) {
    suspend fun insertar(ocupacion: Ocupacion){
        ocupacionDao.insertar(ocupacion)
    }

    suspend fun eliminar(ocupacion: Ocupacion){
        ocupacionDao.eliminar(ocupacion)
    }

    fun buscar(ocupacionId: Int): Flow<List<Ocupacion>> {
        return ocupacionDao.buscar(ocupacionId)
    }

    fun getLista(): Flow<List<Ocupacion>>{
        return ocupacionDao.getLista()
    }
}