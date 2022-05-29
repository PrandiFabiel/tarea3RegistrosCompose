package com.example.tarea3registroscompose.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun OcupacionScreen(
    modifier: Modifier = Modifier,
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
                value = "",
                onValueChange = {  },
                modifier = modifier.fillMaxWidth()
            )
        }
    }

}