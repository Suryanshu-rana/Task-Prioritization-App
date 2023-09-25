package com.example.todoapp.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.todoapp.data.room.database.TodoDatabase
import com.example.todoapp.data.room.model.Todo
import com.example.todoapp.data.room.repository.TodoRepository
import kotlinx.coroutines.flow.Flow

class TodoViewModel(application: Application): AndroidViewModel(application) {

    private var _todolist :Flow<List<Todo>>
    private var repository:TodoRepository
    init {
        val todoDao = TodoDatabase.getInstance(application).todoDao()
        repository = TodoRepository(todoDao)
        _todolist = repository.allTodos
    }
    fun getTodoList(): Flow<List<Todo>> {
        return repository.allTodos
    }
    fun addtodo(todo: Todo){
        repository.insertTodo(todo)
    }
    fun deleteTodo(todo: Todo){
        Log.v("delete todo at repo",todo.toString())
        repository.deleteTodo(todo)
    }
    fun ischecked(todo: Todo, value:Boolean){
        addtodo(todo.also { it.checked = value })
    }
}