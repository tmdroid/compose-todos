package de.dannyb.composetodos.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import de.dannyb.composetodos.data.models.ToDoTask
import de.dannyb.composetodos.util.Constants
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {

    @Query("SELECT * FROM ${Constants.DATABASE_TABLE} ORDER BY id ASC")
    fun getAllTasks(): Flow<List<ToDoTask>>

    @Query("SELECT * FROM ${Constants.DATABASE_TABLE} WHERE id=:id LIMIT 1")
    fun getSelectedTask(id: Int): Flow<ToDoTask>

    @Query(
        "SELECT * FROM ${Constants.DATABASE_TABLE} " +
                "WHERE title LIKE '%' || :query || '%' " +
                "OR description LIKE '%' || :query || '%'"
    )
    fun searchForTask(query: String): Flow<List<ToDoTask>>

    @Query(
        "SELECT * FROM ${Constants.DATABASE_TABLE} ORDER BY CASE " +
                "WHEN priority LIKE 'L%' THEN 1 " +
                "WHEN priority LIKE 'M%' THEN 2 " +
                "WHEN priority LIKE 'H%' THEN 3 " +
                "END"
    )
    fun sortByPriority(): Flow<List<ToDoTask>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(toDoTask: ToDoTask)

    @Update
    suspend fun updateTask(toDoTask: ToDoTask)

    @Delete
    suspend fun deleteTask(toDoTask: ToDoTask)

    @Query("DELETE FROM ${Constants.DATABASE_TABLE}")
    suspend fun deleteAllTasks()


}