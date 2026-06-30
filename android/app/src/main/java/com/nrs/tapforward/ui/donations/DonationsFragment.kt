package com.nrs.tapforward.ui.donations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.nrs.tapforward.R
import com.nrs.tapforward.databinding.FragmentDonationsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DonationsFragment : Fragment() {

    private var _binding: FragmentDonationsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DonationsViewModel by viewModels()
    private lateinit var adapter: DonationsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDonationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = DonationsAdapter()
        binding.rvDonations.layoutManager = LinearLayoutManager(requireContext())
        binding.rvDonations.adapter = adapter

        binding.fabNewDonation.setOnClickListener {
            findNavController().navigate(R.id.action_donationsFragment_to_newDonationFragment)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.donations.collect { donations ->
                    adapter.submitList(donations)
                    binding.tvEmpty.visibility = if (donations.isEmpty()) View.VISIBLE else View.GONE
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
