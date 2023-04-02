package de.dannyb.composetodos.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import de.dannyb.composetodos.util.Constants.DATABASE_TABLE

@Entity(tableName = DATABASE_TABLE)
data class ToDoTask(
    val title: String,
    val description: String,
    val priority: Priority,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
)
