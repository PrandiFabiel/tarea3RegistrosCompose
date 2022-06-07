package com.example.tarea3registroscompose.ui.persona

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tarea3registroscompose.model.Ocupacion
import com.example.tarea3registroscompose.model.Persona
import com.example.tarea3registroscompose.ui.ocupacion.OcupacionViewModel
import com.example.tarea3registroscompose.ui.theme.Tarea3RegistrosComposeTheme

@Composable
fun PersonaListScreen(
    onNavigateToPersona: () -> Unit,
    onNavigateToListOcupacion: () -> Unit,
    viewModel: PersonaViewModel = hiltViewModel()
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Persona List") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                     onNavigateToPersona()
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Nuevo")
            }
        },

    ) {
        Column(modifier = Modifier.padding(it)) {

            Column(modifier = Modifier.padding(16.dp)) {
                Button(onClick = { onNavigateToListOcupacion() }, Modifier.padding(top = 8.dp)) {
                    Text(text = "Ocupaciones")
                }
            }

            Row(horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()){
                Text(
                    text = "Ocupacion",
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Nombre",
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Salario",
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold
                )
            }

            val listaPersonas = viewModel.personas.collectAsState(initial = emptyList())
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(listaPersonas.value) { persona ->
                    PersonaRow(persona)
                }
            }
        }
    }

}


@Composable
fun PersonaRow(persona: Persona) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                enabled = true,
                onClick = { })
    )

    {
        Row(horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .height(25.dp)) {
            Text(
                text =  getNombreOcupacion(ocup = persona.ocupacionId),
                maxLines = 1,

            )
            Text(
                text = persona.nombres,

            )
            Text(
                text = persona.salario.toString(),

            )
        }

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Tarea3RegistrosComposeTheme {
        //PersonaListScreen()
    }
}
@Composable
fun getNombreOcupacion(ocup: Int, viewModel: OcupacionViewModel = hiltViewModel(),): String {
    var name: String = "";
    val ocupaciones = viewModel.ocupaciones.collectAsState(initial = emptyList())

    ocupaciones.value.forEach{ element ->
        if (ocup == element.ocupacionId){
            name = element.nombre
        }
    }

    return name
}
