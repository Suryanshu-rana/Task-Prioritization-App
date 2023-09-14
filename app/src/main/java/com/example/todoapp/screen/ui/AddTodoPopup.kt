package com.example.todoapp.screen.ui

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.DialogProperties
import com.example.todoapp.model.Todo
import com.example.todoapp.viewModel.TodoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTodoPopup(
    showscreen: MutableState<Boolean>,
    todoviewmodel: TodoViewModel,
    title: @Composable() () -> Unit,
    icon: @Composable() () -> Unit,
) {
    var todoText by remember { mutableStateOf("") }

    AlertDialog(properties = DialogProperties(
        dismissOnBackPress = true,
        dismissOnClickOutside = true
    ),
        title = title,
        icon = icon,
        text = {
            OutlinedTextField(value = todoText,
                placeholder = {
                    Text(text = "Enter text here ...")
                },
                onValueChange = {
                    todoText = it
                }
            )
        },
        confirmButton = {
            TextButton(onClick = {
                if (todoText.isNotEmpty()) {
                    todoviewmodel.addtodo(Todo(id = 1.1, name = todoText, checked = false))
                    showscreen.value = false
                }
            }) {
                Text(text = "Submit", style = MaterialTheme.typography.labelLarge)
            }
        },
        dismissButton = {
            TextButton(onClick = { showscreen.value = false }) {
                Text(text = "Cancel", style = MaterialTheme.typography.labelLarge)
            }
        },
        iconContentColor = Color(0xff800080),
        onDismissRequest = {
            showscreen.value = false
        }
    )
}