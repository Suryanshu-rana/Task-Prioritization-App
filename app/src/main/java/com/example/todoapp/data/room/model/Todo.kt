package com.example.todoapp.data.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Todos")
data class Todo(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "checked")
    var checked: Boolean
) {
    constructor(name: String, checked: Boolean) : this(0, name, checked)
}
