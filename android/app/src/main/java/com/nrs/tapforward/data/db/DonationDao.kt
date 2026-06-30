package com.nrs.tapforward.data.db

import androidx.room.*
import com.nrs.tapforward.data.model.Donation
import kotlinx.coroutines.flow.Flow

@Dao
interface DonationDao {
    @Query("SELECT * FROM donations ORDER BY timestamp DESC")
    fun getAllDonations(): Flow<List<Donation>>

    @Query("SELECT * FROM donations WHERE timestamp >= :startMs AND timestamp <= :endMs ORDER BY timestamp DESC")
    fun getDonationsInRange(startMs: Long, endMs: Long): Flow<List<Donation>>

    @Query("SELECT SUM(amountCents) FROM donations WHERE timestamp >= :startMs AND timestamp <= :endMs")
    fun getTotalInRange(startMs: Long, endMs: Long): Flow<Long?>

    @Query("SELECT * FROM donations WHERE memberId = :memberId ORDER BY timestamp DESC")
    fun getDonationsForMember(memberId: Long): Flow<List<Donation>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(donation: Donation): Long

    @Update
    suspend fun update(donation: Donation)

    @Delete
    suspend fun delete(donation: Donation)

    @Query("SELECT COUNT(*) FROM donations WHERE timestamp >= :startMs AND timestamp <= :endMs")
    fun getCountInRange(startMs: Long, endMs: Long): Flow<Int>
}
