package com.nrs.tapforward.data.db

import androidx.room.*
import com.nrs.tapforward.data.model.Member
import kotlinx.coroutines.flow.Flow

@Dao
interface MemberDao {
    @Query("SELECT * FROM members WHERE isActive = 1 ORDER BY lastName ASC, firstName ASC")
    fun getAllActiveMembers(): Flow<List<Member>>

    @Query("SELECT * FROM members WHERE firstName LIKE '%' || :query || '%' OR lastName LIKE '%' || :query || '%' OR email LIKE '%' || :query || '%'")
    fun searchMembers(query: String): Flow<List<Member>>

    @Query("SELECT * FROM members WHERE id = :id")
    suspend fun getById(id: Long): Member?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(member: Member): Long

    @Update
    suspend fun update(member: Member)

    @Query("UPDATE members SET totalGivenCents = totalGivenCents + :amountCents WHERE id = :memberId")
    suspend fun addToTotalGiven(memberId: Long, amountCents: Long)
}
