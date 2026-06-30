package com.nrs.tapforward.data.repository

import com.nrs.tapforward.data.db.DonationDao
import com.nrs.tapforward.data.db.MemberDao
import com.nrs.tapforward.data.model.Donation
import kotlinx.coroutines.flow.Flow
import java.util.Calendar
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DonationRepository @Inject constructor(
    private val donationDao: DonationDao,
    private val memberDao: MemberDao
) {
    fun getAllDonations(): Flow<List<Donation>> = donationDao.getAllDonations()

    fun getThisMonthDonations(): Flow<List<Donation>> {
        val cal = Calendar.getInstance()
        cal.set(Calendar.DAY_OF_MONTH, 1)
        cal.set(Calendar.HOUR_OF_DAY, 0)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)
        val start = cal.timeInMillis
        val end = System.currentTimeMillis()
        return donationDao.getDonationsInRange(start, end)
    }

    fun getMonthlyTotal(): Flow<Long?> {
        val cal = Calendar.getInstance()
        cal.set(Calendar.DAY_OF_MONTH, 1)
        cal.set(Calendar.HOUR_OF_DAY, 0)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)
        return donationDao.getTotalInRange(cal.timeInMillis, System.currentTimeMillis())
    }

    fun getDonationsForMember(memberId: Long): Flow<List<Donation>> =
        donationDao.getDonationsForMember(memberId)

    suspend fun recordDonation(donation: Donation): Long {
        val id = donationDao.insert(donation)
        donation.memberId?.let { memberDao.addToTotalGiven(it, donation.amountCents) }
        return id
    }
}
