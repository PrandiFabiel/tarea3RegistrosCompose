package com.example.tarea3registroscompose.util

sealed class Screen(val route: String){
    object PersonaScreen: Screen("Persona")
    object PersonaListScreen: Screen("PersonaList")

    object OcupacionScreen: Screen("Ocupacion")
    object OcupacionListScreen: Screen("OcupacionList")
}
