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
import com.example.tarea3registroscompose.ui.theme.Tarea3RegistrosComposeTheme
import com.example.tarea3registroscompose.ui.screens.PersonaListScreen
import com.example.tarea3registroscompose.ui.screens.PersonaScreen
import com.example.tarea3registroscompose.util.screen


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

            NavHost(navController = navHostController, startDestination = screen.PersonaListScreen.route){
                composable(route =screen.PersonaListScreen.route ){
                    PersonaListScreen(
                        onNavigateToPersona =  {navHostController.navigate(screen.PersonaScreen.route)}
                    )
                }
                composable(route =screen.PersonaScreen.route ){
                    PersonaScreen(onSave = {navHostController.navigateUp()})
                }
            }
        }
    }
}

