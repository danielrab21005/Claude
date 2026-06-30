package com.nrs.tapforward.util

import java.text.NumberFormat
import java.util.Locale

fun formatCurrency(cents: Long): String {
    val dollars = cents / 100.0
    return NumberFormat.getCurrencyInstance(Locale.US).format(dollars)
}
