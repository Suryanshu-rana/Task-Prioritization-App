package com.example.todoapp.Screen.UI

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
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.todoapp.viewModel.TodoViewModel


@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun Home() {
    val showscreen = remember { mutableStateOf(false) }
    val todoviewmodel by remember { mutableStateOf(TodoViewModel()) }
    var delete by remember { mutableStateOf(false) }
    val showdelete = remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Todo App")
                })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                showscreen.value = true
                delete = false
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Icon")
                if (showscreen.value) {
                    AddTodoPopup(showscreen, todoviewmodel,
                        title = { Text(text = "Add Todo") },
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
            items(todoviewmodel.getTodoList()) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .combinedClickable(onLongClick = {
                            delete = !delete
                        }) { },
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(5.dp)
                            .padding(start = 8.dp)
                            .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
                    )
                    {
                        Text(
                            modifier = Modifier.fillMaxWidth(.7F),
                            text = it.name, textDecoration =
                            if (it.checked) {
                                TextDecoration.LineThrough
                            } else {
                                TextDecoration.None
                            }
                        )
                        RadioButton(selected = it.checked, onClick = {
                            Log.v("this is the input ", it.checked.toString())
                            todoviewmodel.ischecked(it, value = !it.checked)
                            Log.v("this is the input ", it.checked.toString())
                        })
                        if (delete) {
                            IconButton(onClick = { showdelete.value = true }) {
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = "delete icon",
                                    tint = Color(0xffff0f0f)
                                )
                                if (showdelete.value) {
                                    DeleteFunction(
                                        todoviewmodel = todoviewmodel,
                                        todo = it,
                                        showdelete = showdelete
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
