package com.example.todoapp.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.todoapp.model.Todo

class TodoViewModel: ViewModel() {

    private var _todolist = mutableStateListOf<Todo>()

    fun getTodoList(): SnapshotStateList<Todo> {
        return _todolist
    }
    fun addtodo(todo:Todo){
        _todolist.add(todo)
    }
    fun deleteTodo(todo:Todo){
        _todolist.remove(todo)
    }
    fun ischecked(todo: Todo,value:Boolean){
        val index = _todolist.indexOf(todo)
       _todolist[index] = _todolist[index].let {
            it.copy(
              id = it.id,
                name = it.name,
                checked = value
            )
        }
        Log.v("this is the input2 ",_todolist[index].checked.toString())
    }
}