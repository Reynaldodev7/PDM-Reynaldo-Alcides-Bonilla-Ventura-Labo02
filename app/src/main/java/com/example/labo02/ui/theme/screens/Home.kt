package com.example.labo02.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WelcomeScreen(onStart: () -> Unit, onStart2: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {



        Text(text = "Nombre: Reynaldo Alcides Bonilla Ventura")
        Text(text = "Carnet: 00107117")

        Spacer(modifier = Modifier.height(40.dp))

        Button(onClick = onStart) {
            Text(text = "Pantalla Listado")
        }

        Button(onClick = onStart2) {
            Text(text = "Pantalla Sensor")
        }
    }
}