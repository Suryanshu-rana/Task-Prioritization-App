package com.example.todoapp.screen.ui

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todoapp.viewModel.TodoViewModel

@Preview
@Composable
fun AddButton() {
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun Home(todoViewModel: TodoViewModel) {
    val showscreen = remember { mutableStateOf(false) }
    var delete by remember { mutableStateOf(false) }
    var checked by remember { mutableStateOf(false) }
//    var showDelete = remember { mutableStateOf(false) }
    val todoItems by todoViewModel.getTodoList().collectAsState(emptyList())
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Todo App") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                showscreen.value = true
                delete = false
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Addition Icon")
                if (showscreen.value) {
                    AddTodoPopup(showscreen, todoViewModel, title = { Text(text = "Add Todo") },
                        icon = {
                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = "Addd a todo"
                            )
                        })
                }
            }
        })
    {
        LazyColumn(modifier = Modifier.padding(it)) {
            items(todoItems) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .combinedClickable(onLongClick = {
                            delete = !delete
                        }) {},
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .padding(5.dp)
                            .padding(start = 8.dp)
                            .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        checked = it.checked
                        Text(
                            modifier = Modifier.fillMaxWidth(.7F),
                            text = it.name, textDecoration =
                            if (checked) {
                                TextDecoration.LineThrough
                            } else {
                                TextDecoration.None
                            }
                        )
                        RadioButton(selected = it.checked, onClick = {
                            todoViewModel.ischecked(it, value = !it.checked)
                            checked = !checked
                        })
                        Log.v("delete todo value before the fun", it.toString())
                        if (delete) {
                            IconButton(onClick = { todoViewModel.deleteTodo(it) }) {
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = "delete icon",
                                    tint = Color(0xffff0f0f)
                                )
//                                if (showDelete.value) {
//                                    Log.v("delete todo at Home", it.toString())
//                                    DeleteFunction(
//                                        todoViewModel = todoViewModel,
//                                        todo = it,
//                                        showdelete = {
//                                            showDelete.value = it
//                                        }
//                                    )
//                                }
                            }
                        }
                    }
                }
            }
        }
    }
}