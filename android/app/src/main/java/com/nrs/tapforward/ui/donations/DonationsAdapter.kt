package com.nrs.tapforward.ui.donations

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nrs.tapforward.data.model.Donation
import com.nrs.tapforward.databinding.ItemDonationBinding
import com.nrs.tapforward.util.formatCurrency
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DonationsAdapter : ListAdapter<Donation, DonationsAdapter.ViewHolder>(DIFF_CALLBACK) {

    inner class ViewHolder(private val binding: ItemDonationBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(donation: Donation) {
            binding.tvMemberName.text = donation.memberName.ifEmpty { "Anonymous" }
            binding.tvAmount.text = formatCurrency(donation.amountCents)
            binding.tvFund.text = donation.fund.name.lowercase().replaceFirstChar { it.uppercase() }
            binding.tvMethod.text = donation.paymentMethod.name
            binding.tvTime.text = SimpleDateFormat("MMM d, h:mm a", Locale.getDefault())
                .format(Date(donation.timestamp))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDonationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Donation>() {
            override fun areItemsTheSame(oldItem: Donation, newItem: Donation) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Donation, newItem: Donation) = oldItem == newItem
        }
    }
}
