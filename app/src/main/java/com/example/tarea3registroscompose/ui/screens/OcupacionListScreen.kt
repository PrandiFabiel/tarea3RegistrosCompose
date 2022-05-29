package com.example.tarea3registroscompose.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tarea3registroscompose.ui.theme.Tarea3RegistrosComposeTheme

@Composable
fun OcupacionListScreen(
    onNavigateToOcupacion: () -> Unit,
) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Ocupacion List") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onNavigateToOcupacion()
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Nuevo")
            }
        },
        scaffoldState = scaffoldState
    ) {
        Column(modifier = Modifier.padding(it)) {
            Row(modifier = Modifier){
                Text(
                    text = "ID",
                    modifier = Modifier.padding(start = 20.dp),
                    style = MaterialTheme.typography.h5
                )
                Text(
                    text = "Descripcion",
                    modifier = Modifier.padding(start = 140.dp),
                    style = MaterialTheme.typography.h5
                )
            }
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(5) { index ->
                    OcupacionRow(ID = "$index", Description = "Ingeniero", onClick = {})
                }
            }
        }
    }

}


@Composable
fun OcupacionRow(ID: String, Description: String, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                enabled = true,
                onClick = { })
    )

    {
        Row(modifier = Modifier.padding(top = 10.dp)) {
            Text(
                text = ID,
                maxLines = 1,
                modifier = Modifier.padding(start = 20.dp)
            )
            Text(
                text = Description,
                modifier = Modifier.padding(start = 185.dp)
            )
        }

    }

}

@Preview(showBackground = true)
@Composable
fun PreviewListOcupacion() {
    Tarea3RegistrosComposeTheme {

    }
}