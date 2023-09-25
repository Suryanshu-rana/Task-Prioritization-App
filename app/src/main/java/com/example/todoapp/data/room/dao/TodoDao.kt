package com.example.todoapp.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.todoapp.data.room.model.Todo
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todo:Todo)
    @Delete
    suspend fun deleteTodo(todo:Todo)

    @Query(value = "Select * from Todos")
    fun getAllTodos() : Flow<List<Todo>>

}