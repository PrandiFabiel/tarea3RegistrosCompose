package com.example.tarea3registroscompose.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.example.tarea3registroscompose.ui.theme.Tarea3RegistrosComposeTheme

@Composable
fun PersonaScreen(
    modifier: Modifier = Modifier,
    onSave: () -> Unit
) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Registro Personas") }
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
                    Text(text = "Nombre")
                },
                value = "",
                onValueChange = {  },
                modifier = modifier.fillMaxWidth()
            )
            OutlinedTextField(
                label = {
                    Text(text = "Salario")
                },
                value = "",
                onValueChange = { },
                modifier =  modifier.fillMaxWidth()
            )
            OutlinedTextField(
                label = {
                    Text(text = "Email")
                },
                value = "",
                onValueChange = { },
                modifier =  modifier.fillMaxWidth()
            )
            Spinner()
        }
    }

}

@Composable
fun Spinner(){

    var mExpanded by remember { mutableStateOf(false) }

    val ocupaciones = listOf("Ingeniero", "Doctor", "Abogado")

    var mSelectedText by remember { mutableStateOf("") }

    var mTextFieldSize by remember { mutableStateOf(Size.Zero)}

    val icon = if (mExpanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Column(Modifier.padding(10.dp).fillMaxWidth()) {

        OutlinedTextField(
            value = mSelectedText,
            onValueChange = { mSelectedText = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    mTextFieldSize = coordinates.size.toSize()
                },
            label = {Text("Ocupacion")},
            trailingIcon = {
                Icon(icon,"contentDescription",
                    Modifier.clickable { mExpanded = !mExpanded })
            }
        )
        DropdownMenu(
            expanded = mExpanded,
            onDismissRequest = { mExpanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current){mTextFieldSize.width.toDp()})
        ) {
            ocupaciones.forEach { label ->
                DropdownMenuItem(onClick = {
                    mSelectedText = label
                    mExpanded = false
                }) {
                    Text(text = label)
                }
            }
        }
    }
}

