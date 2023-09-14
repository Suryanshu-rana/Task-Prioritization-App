package com.example.todoapp.screen.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.DialogProperties
import com.example.todoapp.model.Todo
import com.example.todoapp.viewModel.TodoViewModel

@Composable
fun DeleteFunction(todoviewmodel: TodoViewModel, todo: Todo, showdelete: MutableState<Boolean>) {
    AlertDialog(
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true
        ),
        icon = {
            Icon(
                imageVector = Icons.Default.Warning,
                contentDescription = "warning",
                tint = Color(0xffffcc00)
            )
        },
        title = { Text(text = "Delete Item") },
        text = {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth(0.9f)) {
                Text(text = "Do you want to delete this todo ?")
            }
        },
        onDismissRequest = { showdelete.value = false },
        confirmButton = {
            TextButton(onClick = {
                todoviewmodel.deleteTodo(todo)
                showdelete.value = false
            }) {
                Text(text = "Delete", style = MaterialTheme.typography.labelLarge)
            }
        }, dismissButton = {
            TextButton(
                onClick = { showdelete.value = false }) {
                Text(text = "Cancel", style = MaterialTheme.typography.labelLarge)
            }
        }
    )
}

