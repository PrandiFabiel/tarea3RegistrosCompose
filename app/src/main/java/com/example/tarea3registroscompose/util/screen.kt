package com.example.tarea3registroscompose.util

sealed class screen(val route: String){
    object PersonaScreen: screen("Persona")
    object PersonaListScreen: screen("PersonaList")
}
