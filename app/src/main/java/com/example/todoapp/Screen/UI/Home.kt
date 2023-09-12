package com.example.todoapp.Screen.UI

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Todo App")
                })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Icon")
            }
        }) {

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTodoPopup() {
    AlertDialog(title = { Text(text = "Add Todo") }, icon = {
        Icon(
            imageVector = Icons.Default.CheckCircle,
            contentDescription = "Addd a todo"
        )
    }, onDismissRequest = { },
        confirmButton = { Text(text = "Submit", style = MaterialTheme.typography.labelLarge) },
        dismissButton = { Text(text = "Cancel", style = MaterialTheme.typography.labelLarge) },
        iconContentColor = Color(0xff800080),
        text = {
            var todoText  by remember {mutableStateOf("")}
            OutlinedTextField( value = todoText,
                placeholder = {
                              Text(text = "Enter text here ...")
                },
                onValueChange = {
                todoText = it
            })
        })
}

@Preview(showSystemUi = true)
@Composable
fun Homepreveie() {
//    Home()
    AddTodoPopup()
}