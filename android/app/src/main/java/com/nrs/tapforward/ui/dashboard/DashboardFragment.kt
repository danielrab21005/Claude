package com.nrs.tapforward.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.nrs.tapforward.databinding.FragmentDashboardBinding
import com.nrs.tapforward.util.formatCurrency
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DashboardViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.monthlyTotal.collect { total ->
                        binding.tvMonthlyTotal.text = formatCurrency(total ?: 0L)
                    }
                }
                launch {
                    viewModel.recentDonations.collect { donations ->
                        binding.tvDonationCount.text = "${donations.size} this month"
                    }
                }
                launch {
                    viewModel.upcomingEvents.collect { events ->
                        binding.tvUpcomingEvents.text = "${events.size} upcoming"
                        events.firstOrNull()?.let { next ->
                            binding.tvNextEvent.text = next.title
                        }
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
