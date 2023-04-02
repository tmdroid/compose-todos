package de.dannyb.composetodos.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.dannyb.composetodos.data.repositories.ToDoRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repository: ToDoRepository
) : ViewModel() {

    val allTasks = repository.getAllTasks.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(FLOW_SLEEP_TIMEOUT),
        initialValue = emptyList()
    )

    companion object {
        private const val FLOW_SLEEP_TIMEOUT = 5000L
    }
}