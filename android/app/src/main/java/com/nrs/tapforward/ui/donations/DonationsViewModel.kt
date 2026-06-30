package com.nrs.tapforward.ui.donations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nrs.tapforward.data.model.Donation
import com.nrs.tapforward.data.model.DonationFund
import com.nrs.tapforward.data.model.PaymentMethod
import com.nrs.tapforward.data.repository.DonationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DonationsViewModel @Inject constructor(
    private val repository: DonationRepository
) : ViewModel() {

    val donations: Flow<List<Donation>> = repository.getAllDonations()

    fun recordDonation(
        memberName: String,
        memberId: Long?,
        amountCents: Long,
        fund: DonationFund,
        method: PaymentMethod,
        note: String = ""
    ) {
        viewModelScope.launch {
            repository.recordDonation(
                Donation(
                    memberName = memberName,
                    memberId = memberId,
                    amountCents = amountCents,
                    fund = fund,
                    paymentMethod = method,
                    note = note
                )
            )
        }
    }
}
