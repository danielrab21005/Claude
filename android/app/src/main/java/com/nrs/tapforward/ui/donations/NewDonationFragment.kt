package com.nrs.tapforward.ui.donations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nrs.tapforward.data.model.DonationFund
import com.nrs.tapforward.data.model.PaymentMethod
import com.nrs.tapforward.databinding.FragmentNewDonationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewDonationFragment : Fragment() {

    private var _binding: FragmentNewDonationBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DonationsViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentNewDonationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val funds = DonationFund.entries.map { it.name.lowercase().replaceFirstChar { c -> c.uppercase() } }
        binding.spinnerFund.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, funds)

        binding.btnTap.setOnClickListener { submitDonation(PaymentMethod.TAP) }
        binding.btnCard.setOnClickListener { submitDonation(PaymentMethod.CARD) }
        binding.btnQr.setOnClickListener { submitDonation(PaymentMethod.QR) }
        binding.btnCash.setOnClickListener { submitDonation(PaymentMethod.CASH) }
    }

    private fun submitDonation(method: PaymentMethod) {
        val name = binding.etDonorName.text?.toString()?.trim() ?: ""
        val amountStr = binding.etAmount.text?.toString()?.trim() ?: ""

        if (amountStr.isEmpty()) {
            Toast.makeText(requireContext(), "Please enter an amount", Toast.LENGTH_SHORT).show()
            return
        }

        val amountCents = (amountStr.toDoubleOrNull() ?: 0.0).times(100).toLong()
        if (amountCents <= 0) {
            Toast.makeText(requireContext(), "Please enter a valid amount", Toast.LENGTH_SHORT).show()
            return
        }

        val fund = DonationFund.entries[binding.spinnerFund.selectedItemPosition]

        viewModel.recordDonation(
            memberName = name.ifEmpty { "Anonymous" },
            memberId = null,
            amountCents = amountCents,
            fund = fund,
            method = method,
            note = binding.etNote.text?.toString()?.trim() ?: ""
        )

        Toast.makeText(requireContext(), "Donation recorded!", Toast.LENGTH_SHORT).show()
        findNavController().navigateUp()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
