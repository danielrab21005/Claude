package com.nrs.tapforward.ui.events

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nrs.tapforward.data.model.Event
import com.nrs.tapforward.data.model.EventType
import com.nrs.tapforward.data.repository.EventRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventsViewModel @Inject constructor(private val repository: EventRepository) : ViewModel() {

    val events: Flow<List<Event>> = repository.getAllEvents()

    fun createEvent(
        title: String,
        description: String,
        type: EventType,
        startMs: Long,
        endMs: Long,
        location: String,
        expectedAttendance: Int
    ) {
        viewModelScope.launch {
            repository.save(
                Event(
                    title = title,
                    description = description,
                    type = type,
                    startTimestamp = startMs,
                    endTimestamp = endMs,
                    location = location,
                    expectedAttendance = expectedAttendance
                )
            )
        }
    }

    fun deleteEvent(event: Event) {
        viewModelScope.launch { repository.delete(event) }
    }
}
