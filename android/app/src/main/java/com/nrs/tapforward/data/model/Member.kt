package com.nrs.tapforward.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "members")
data class Member(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val firstName: String,
    val lastName: String,
    val email: String = "",
    val phone: String = "",
    val address: String = "",
    val joinedTimestamp: Long = System.currentTimeMillis(),
    val totalGivenCents: Long = 0,
    val isActive: Boolean = true,
    val notes: String = ""
) {
    val fullName: String get() = "$firstName $lastName"
}
