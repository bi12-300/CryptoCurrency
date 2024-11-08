package com.example.cryptocurrency.fragment.invest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
            val fragment = InvestAddFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment) // `fragment_container` là ID của container layout
                .addToBackStack(null)
                .commit()
        }

        binding.buttonWithdraw.setOnClickListener {
            val fragment = InvestBuyFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
