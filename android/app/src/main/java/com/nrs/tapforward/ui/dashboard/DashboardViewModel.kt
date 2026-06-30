package com.nrs.tapforward.ui.dashboard

import androidx.lifecycle.ViewModel
import com.nrs.tapforward.data.model.Donation
import com.nrs.tapforward.data.model.Event
import com.nrs.tapforward.data.repository.DonationRepository
import com.nrs.tapforward.data.repository.EventRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    donationRepository: DonationRepository,
    eventRepository: EventRepository
) : ViewModel() {

    val monthlyTotal: Flow<Long?> = donationRepository.getMonthlyTotal()
    val recentDonations: Flow<List<Donation>> = donationRepository.getThisMonthDonations()
    val upcomingEvents: Flow<List<Event>> = eventRepository.getUpcomingEvents()
}
