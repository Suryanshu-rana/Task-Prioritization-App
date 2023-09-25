package com.example.todoapp.data.room.repository

import com.example.todoapp.data.room.dao.TodoDao
import com.example.todoapp.data.room.model.Todo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class TodoRepository(private val todoDao: TodoDao) {
    val allTodos: Flow<List<Todo>> = todoDao.getAllTodos()
    private var coroutineScope = GlobalScope
    fun insertTodo(todo: Todo): Unit {
        coroutineScope.launch {
            todoDao.insertTodo(todo)
        }
    }

    fun deleteTodo(todo: Todo) {
        coroutineScope.launch {
            todoDao.deleteTodo(todo)
        }
    }
}