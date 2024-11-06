package com.example.cryptocurrency.fragment.invest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.cryptocurrency.databinding.InvestBinding
import com.example.cryptocurrency.R

class InvestFragment : Fragment(R.layout.invest) {

    private var _binding: InvestBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = InvestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Điều hướng tới InvestAddFragment khi nhấn "Nạp tiền"
        binding.buttonInvest.setOnClickListener {
            findNavController().navigate(R.id.action_InvestFragment_to_InvestAddFragment)
        }

        // Điều hướng tới InvestBuyFragment khi nhấn "Buy"
        binding.buttonWithdraw.setOnClickListener {
            findNavController().navigate(R.id.action_InvestFragment_to_InvestBuyFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
