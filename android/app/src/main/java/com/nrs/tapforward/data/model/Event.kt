package com.nrs.tapforward.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

enum class EventType { SERVICE, REVIVAL, FUNDRAISER, MEETING, COMMUNITY, OTHER }

@Entity(tableName = "events")
data class Event(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val description: String = "",
    val type: EventType,
    val startTimestamp: Long,
    val endTimestamp: Long,
    val location: String = "",
    val expectedAttendance: Int = 0,
    val actualAttendance: Int = 0,
    val donationsTotal: Long = 0,
    val isActive: Boolean = true
)
