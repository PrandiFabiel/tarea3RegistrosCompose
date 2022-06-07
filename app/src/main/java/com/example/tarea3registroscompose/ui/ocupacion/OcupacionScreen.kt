package com.example.tarea3registroscompose.ui.ocupacion

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.Work
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tarea3registroscompose.model.Ocupacion

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun OcupacionScreen(
    viewModel: OcupacionViewModel = hiltViewModel(),
    onSave: () -> Unit
) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Registro Ocupaciones") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onSave()
                    viewModel.Guardar()
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Save, contentDescription = "New")
            }
        },
        scaffoldState = scaffoldState
    ) {
        Column(modifier = Modifier.padding(10.dp)) {

            OutlinedTextField(
                label = {
                    Text(text = "Descripcion")
                },
                value = viewModel.nombre,
                onValueChange = { viewModel.nombre = it },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Work, contentDescription = null)
                }
            )
        }
    }

}