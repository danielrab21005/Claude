package com.nrs.tapforward.data.repository

import com.nrs.tapforward.data.db.MemberDao
import com.nrs.tapforward.data.model.Member
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MemberRepository @Inject constructor(private val memberDao: MemberDao) {
    fun getAllActiveMembers(): Flow<List<Member>> = memberDao.getAllActiveMembers()
    fun searchMembers(query: String): Flow<List<Member>> = memberDao.searchMembers(query)
    suspend fun getById(id: Long): Member? = memberDao.getById(id)
    suspend fun save(member: Member): Long = memberDao.insert(member)
    suspend fun update(member: Member) = memberDao.update(member)
}
