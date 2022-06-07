package com.example.tarea3registroscompose.ui.persona

import android.annotation.SuppressLint
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
import androidx.compose.material.icons.filled.Work
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tarea3registroscompose.ui.ocupacion.OcupacionViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PersonaScreen(
    modifier: Modifier = Modifier,
    viewModel: PersonaViewModel = hiltViewModel(),
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
                     viewModel.Guardar()
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
                value = viewModel.nombres,
                onValueChange = { viewModel.nombres = it },
                modifier = modifier.fillMaxWidth()
            )
            OutlinedTextField(
                label = {
                    Text(text = "Salario")
                },
                value = viewModel.salario,
                onValueChange = { viewModel.salario = it },
                modifier =  modifier.fillMaxWidth()
            )
            OutlinedTextField(
                label = {
                    Text(text = "Email")
                },
                value = viewModel.email,
                onValueChange = { viewModel.email = it },
                modifier =  modifier.fillMaxWidth()
            )
            Spinner()
        }
    }

}

@Composable
fun Spinner(viewModel: OcupacionViewModel = hiltViewModel(),
            personaViewModel: PersonaViewModel = hiltViewModel()
){

    var mExpanded by remember { mutableStateOf(false) }

    val ocupaciones = viewModel.ocupaciones.collectAsState(initial = emptyList())

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
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Work, contentDescription = null)
            },
            readOnly = true
        )
        DropdownMenu(
            expanded = mExpanded,
            onDismissRequest = { mExpanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current){mTextFieldSize.width.toDp()})
        ) {
            ocupaciones.value.forEach {
                DropdownMenuItem(onClick = {
                    personaViewModel.ocupacion = it.ocupacionId
                    mSelectedText = it.nombre
                    mExpanded = false
                }) {
                    Text(text = it.nombre)
                }
            }
        }
    }
}

