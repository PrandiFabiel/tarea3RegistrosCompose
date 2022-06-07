package com.example.tarea3registroscompose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tarea3registroscompose.model.Ocupacion
import com.example.tarea3registroscompose.model.Persona

@Database(
    entities = [
        Persona::class,
        Ocupacion::class
    ],
    exportSchema = false,
    version = 1
)
abstract class PrestamosDb: RoomDatabase() {
    abstract val personaDao: PersonaDao
    abstract val ocupacionDao: OcupacionDao
}