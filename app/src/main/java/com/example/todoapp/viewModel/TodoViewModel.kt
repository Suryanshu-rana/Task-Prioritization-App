package com.example.todoapp.viewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.todoapp.model.Todo

class TodoViewModel: ViewModel() {

    var _todolist = mutableStateListOf<Todo>()

    fun gettodoList(): SnapshotStateList<Todo> {
        return _todolist
    }
    fun addtodo(todo:Todo){
        _todolist.add(todo)
    }
    fun deleteTodo(todo:Todo){
        _todolist.remove(todo)
    }
}