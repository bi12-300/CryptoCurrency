package com.example.cryptocurrency.fragment.Setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.cryptocurrency.R
import com.example.cryptocurrency.databinding.SettingBinding

class SettingFragment : Fragment() {

    private var _binding: SettingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SettingBinding.inflate(inflater, container, false)
        binding.buttonBack.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }

        // Logic cho các button khác nếu cần thiết

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
