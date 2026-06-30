package com.nrs.tapforward.ui.events

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nrs.tapforward.data.model.EventType
import com.nrs.tapforward.databinding.FragmentNewEventBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar

@AndroidEntryPoint
class NewEventFragment : Fragment() {

    private var _binding: FragmentNewEventBinding? = null
    private val binding get() = _binding!!
    private val viewModel: EventsViewModel by viewModels()

    private var startMs = 0L
    private var endMs = 0L

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentNewEventBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val types = EventType.entries.map { it.name.lowercase().replaceFirstChar { c -> c.uppercase() } }
        binding.spinnerEventType.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, types)

        binding.btnPickStart.setOnClickListener { pickDateTime { ms -> startMs = ms; binding.tvStartTime.text = formatMs(ms) } }
        binding.btnPickEnd.setOnClickListener { pickDateTime { ms -> endMs = ms; binding.tvEndTime.text = formatMs(ms) } }

        binding.btnSave.setOnClickListener {
            val title = binding.etEventTitle.text?.toString()?.trim() ?: ""
            if (title.isEmpty()) {
                Toast.makeText(requireContext(), "Please enter a title", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (startMs == 0L) {
                Toast.makeText(requireContext(), "Please select a start time", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            viewModel.createEvent(
                title = title,
                description = binding.etDescription.text?.toString()?.trim() ?: "",
                type = EventType.entries[binding.spinnerEventType.selectedItemPosition],
                startMs = startMs,
                endMs = if (endMs > 0) endMs else startMs + 3_600_000,
                location = binding.etLocation.text?.toString()?.trim() ?: "",
                expectedAttendance = binding.etExpected.text?.toString()?.toIntOrNull() ?: 0
            )

            findNavController().navigateUp()
        }
    }

    private fun pickDateTime(onPicked: (Long) -> Unit) {
        val cal = Calendar.getInstance()
        DatePickerDialog(requireContext(), { _, y, m, d ->
            TimePickerDialog(requireContext(), { _, h, min ->
                cal.set(y, m, d, h, min, 0)
                onPicked(cal.timeInMillis)
            }, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), false).show()
        }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)).show()
    }

    private fun formatMs(ms: Long): String {
        return java.text.SimpleDateFormat("MMM d, yyyy · h:mm a", java.util.Locale.getDefault()).format(java.util.Date(ms))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
