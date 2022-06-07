package com.example.tarea3registroscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tarea3registroscompose.ui.ocupacion.OcupacionListScreen
import com.example.tarea3registroscompose.ui.ocupacion.OcupacionScreen
import com.example.tarea3registroscompose.ui.theme.Tarea3RegistrosComposeTheme
import com.example.tarea3registroscompose.ui.persona.PersonaListScreen
import com.example.tarea3registroscompose.ui.persona.PersonaScreen
import com.example.tarea3registroscompose.util.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrestamosApp()
        }
    }
}

@Composable
fun PrestamosApp(
) {
    Tarea3RegistrosComposeTheme  {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val navHostController = rememberNavController( )

            NavHost(navController = navHostController, startDestination = Screen.PersonaListScreen.route){
                composable(route = Screen.PersonaListScreen.route ){
                    PersonaListScreen(
                        onNavigateToPersona =  {navHostController.navigate(Screen.PersonaScreen.route)},
                        onNavigateToListOcupacion = {navHostController.navigate(Screen.OcupacionListScreen.route)}
                    )
                }
                composable(route = Screen.PersonaScreen.route ){
                    PersonaScreen(onSave = {navHostController.navigateUp()})
                }

                composable(route = Screen.OcupacionListScreen.route){
                    OcupacionListScreen(
                        onNavigateToOcupacion = {navHostController.navigate(Screen.OcupacionScreen.route)}
                    )
                }

                composable(route = Screen.OcupacionScreen.route ){
                    OcupacionScreen(onSave = {navHostController.navigateUp()})
                }

            }
        }
    }
}

