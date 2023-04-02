package de.dannyb.composetodos.data.repositories

import dagger.hilt.android.scopes.ViewModelScoped
import de.dannyb.composetodos.data.ToDoDao
import de.dannyb.composetodos.data.models.ToDoTask
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class ToDoRepository @Inject constructor(
    private val toDoDao: ToDoDao
) {

    val getAllTasks: Flow<List<ToDoTask>> = toDoDao.getAllTasks()

    val sortByLowPriority = toDoDao.sortByPriority()

    fun getSelectedTask(taskId: Int): Flow<ToDoTask> = toDoDao.getSelectedTask(taskId)

    suspend fun addTask(toDoTask: ToDoTask) = toDoDao.addTask(toDoTask)

    suspend fun updateTask(toDoTask: ToDoTask) = toDoDao.updateTask(toDoTask)

    suspend fun deleteTask(toDoTask: ToDoTask) = toDoDao.deleteTask(toDoTask)

    suspend fun deleteAllTasks() = toDoDao.deleteAllTasks()

    fun searchDatabase(query: String): Flow<List<ToDoTask>> = toDoDao.searchForTask(query)

}