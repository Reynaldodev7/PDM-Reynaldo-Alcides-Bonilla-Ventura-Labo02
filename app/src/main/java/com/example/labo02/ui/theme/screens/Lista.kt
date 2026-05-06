package com.example.labo02.ui.theme.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AgregarListas(modifier: Modifier = Modifier, onStart: () -> Unit) {
    val entries = remember { mutableStateListOf<String>() }
    val usuario = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TextField(
            value = usuario.value,
            onValueChange = { usuario.value = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth().padding(top = 20.dp)
        )

        Button(
            onClick = {
                if (usuario.value.isNotBlank()) {
                    entries.add(usuario.value)
                    usuario.value = ""
                }
            },
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Text(text = "Guardar")
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Listado de nombres y posición en la lista",
                modifier = Modifier.weight(1f).padding(end = 8.dp)
            )
            Button(
                onClick = {
                    if (entries.isNotEmpty()) {
                        entries.removeAt(entries.size - 1)
                    }
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Limpiar")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .border(
                    border = BorderStroke(width = 3.dp, Color.Blue),
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(8.dp)
        ) {
            itemsIndexed(entries) { index, item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = item)
                    Text(text = (index + 1).toString())
                }
            }
        }
        Button(onClick = onStart) {
            Text(text = "Pantalla Home")
        }
    }
}