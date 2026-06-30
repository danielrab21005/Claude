package com.nrs.tapforward.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

enum class PaymentMethod { TAP, CARD, QR, CASH }
enum class DonationFund { TITHE, BUILDING, MISSIONS, GENERAL, SPECIAL }

@Entity(tableName = "donations")
data class Donation(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val memberName: String,
    val memberId: Long? = null,
    val amountCents: Long,
    val fund: DonationFund,
    val paymentMethod: PaymentMethod,
    val note: String = "",
    val timestamp: Long = System.currentTimeMillis(),
    val receiptSent: Boolean = false,
    val transactionId: String = ""
)
