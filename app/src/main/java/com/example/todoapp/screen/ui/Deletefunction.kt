package com.example.todoapp.screen.ui

import android.util.Log
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.DialogProperties
import com.example.todoapp.data.room.model.Todo
import com.example.todoapp.viewModel.TodoViewModel

@Composable
fun DeleteFunction(todoViewModel: TodoViewModel, todo: Todo, showdelete: (Boolean) -> Unit) {
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
        onDismissRequest = { showdelete(false) },
        confirmButton = {
            TextButton(onClick = {
                Log.v("delete todo at UI function", todo.toString())
                todoViewModel.deleteTodo(todo)
                showdelete(false)
            }) {
                Text(text = "Delete", style = MaterialTheme.typography.labelLarge)
            }
        }, dismissButton = {
            TextButton(
                onClick = { showdelete(false) }) {
                Text(text = "Cancel", style = MaterialTheme.typography.labelLarge)
            }
        }
    )
}

