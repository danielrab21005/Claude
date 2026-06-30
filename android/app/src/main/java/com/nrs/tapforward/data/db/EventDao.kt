package com.nrs.tapforward.data.db

import androidx.room.*
import com.nrs.tapforward.data.model.Event
import kotlinx.coroutines.flow.Flow

@Dao
interface EventDao {
    @Query("SELECT * FROM events WHERE isActive = 1 ORDER BY startTimestamp ASC")
    fun getUpcomingEvents(): Flow<List<Event>>

    @Query("SELECT * FROM events ORDER BY startTimestamp DESC")
    fun getAllEvents(): Flow<List<Event>>

    @Query("SELECT * FROM events WHERE id = :id")
    suspend fun getById(id: Long): Event?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(event: Event): Long

    @Update
    suspend fun update(event: Event)

    @Delete
    suspend fun delete(event: Event)
}
