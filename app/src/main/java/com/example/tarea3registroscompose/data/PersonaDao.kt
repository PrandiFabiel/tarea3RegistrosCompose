package com.example.tarea3registroscompose.data

import androidx.room.*
import com.example.tarea3registroscompose.model.Persona
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(persona: Persona)

    @Delete
    suspend fun eliminar(persona: Persona)

    @Query("SELECT * FROM personas WHERE  personaId =:persoanId")
    fun buscar(persoanId: Int): Flow<List<Persona>>

    @Query("SELECT * FROM personas ORDER BY personaId")
    fun getLista(): Flow<List<Persona>>
}