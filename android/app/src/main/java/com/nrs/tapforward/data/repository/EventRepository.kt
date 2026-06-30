package com.nrs.tapforward.data.repository

import com.nrs.tapforward.data.db.EventDao
import com.nrs.tapforward.data.model.Event
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EventRepository @Inject constructor(private val eventDao: EventDao) {
    fun getUpcomingEvents(): Flow<List<Event>> = eventDao.getUpcomingEvents()
    fun getAllEvents(): Flow<List<Event>> = eventDao.getAllEvents()
    suspend fun getById(id: Long): Event? = eventDao.getById(id)
    suspend fun save(event: Event): Long = eventDao.insert(event)
    suspend fun update(event: Event) = eventDao.update(event)
    suspend fun delete(event: Event) = eventDao.delete(event)
}
