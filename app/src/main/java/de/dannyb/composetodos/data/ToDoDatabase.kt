package de.dannyb.composetodos.data

import androidx.room.Database
import androidx.room.RoomDatabase
import de.dannyb.composetodos.data.models.ToDoTask

@Database(
    entities = [ToDoTask::class],
    version = 1,
    exportSchema = true,
)
abstract class ToDoDatabase : RoomDatabase() {

    abstract fun toDoDao(): ToDoDao

}