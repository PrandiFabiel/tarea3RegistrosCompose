package com.example.tarea3registroscompose.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "Personas")
@Parcelize
data class Persona(
    @PrimaryKey(autoGenerate = true)
    val personaId: Int = 0,
    val nombres: String,
    val email: String,
    val ocupacionId: Int,
    val salario: Float
): Parcelable
