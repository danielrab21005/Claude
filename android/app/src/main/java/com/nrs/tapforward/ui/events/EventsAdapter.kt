package com.nrs.tapforward.ui.events

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nrs.tapforward.data.model.Event
import com.nrs.tapforward.databinding.ItemEventBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class EventsAdapter : ListAdapter<Event, EventsAdapter.ViewHolder>(DIFF_CALLBACK) {

    inner class ViewHolder(private val binding: ItemEventBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(event: Event) {
            binding.tvEventTitle.text = event.title
            binding.tvEventType.text = event.type.name.lowercase().replaceFirstChar { it.uppercase() }
            binding.tvEventDate.text = SimpleDateFormat("EEE, MMM d · h:mm a", Locale.getDefault())
                .format(Date(event.startTimestamp))
            binding.tvEventLocation.text = event.location.ifEmpty { "Location TBD" }
            if (event.expectedAttendance > 0) {
                binding.tvAttendance.text = "${event.actualAttendance} / ${event.expectedAttendance} attending"
            } else {
                binding.tvAttendance.text = "${event.actualAttendance} attending"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Event>() {
            override fun areItemsTheSame(oldItem: Event, newItem: Event) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Event, newItem: Event) = oldItem == newItem
        }
    }
}
