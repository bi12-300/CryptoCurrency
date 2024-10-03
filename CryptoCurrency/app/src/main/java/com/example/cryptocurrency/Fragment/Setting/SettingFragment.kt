package com.example.cryptocurrency.Fragment.Setting


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import com.example.cryptocurrency.R
import androidx.fragment.app.Fragment

class SettingFragment : Fragment() {
    private lateinit var toolbar: Toolbar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.setting, container, false)

        // Ánh xạ toolbar trong Fragment
        toolbar = view.findViewById(R.id.toolbar)

        // Thêm bất kỳ mã nào khác cần thiết cho fragment này

        return view
    }
}

