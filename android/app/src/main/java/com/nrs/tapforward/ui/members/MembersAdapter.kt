package com.nrs.tapforward.ui.members

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nrs.tapforward.data.model.Member
import com.nrs.tapforward.databinding.ItemMemberBinding
import com.nrs.tapforward.util.formatCurrency

class MembersAdapter : ListAdapter<Member, MembersAdapter.ViewHolder>(DIFF_CALLBACK) {

    inner class ViewHolder(private val binding: ItemMemberBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(member: Member) {
            binding.tvMemberName.text = member.fullName
            binding.tvMemberEmail.text = member.email.ifEmpty { "No email on file" }
            binding.tvTotalGiven.text = "Total given: ${formatCurrency(member.totalGivenCents)}"
            binding.tvInitials.text = "${member.firstName.firstOrNull() ?: ""}${member.lastName.firstOrNull() ?: ""}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMemberBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Member>() {
            override fun areItemsTheSame(oldItem: Member, newItem: Member) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Member, newItem: Member) = oldItem == newItem
        }
    }
}
