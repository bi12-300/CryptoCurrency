package com.example.cryptocurrency.Fragment.New

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.cryptocurrency.R

class NewFragment : Fragment() {

    private lateinit var toolbar: Toolbar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.new_menu, container, false)

        // Ánh xạ toolbar trong Fragment
        toolbar = view.findViewById(R.id.toolbar)

        // Thêm bất kỳ mã nào khác cần thiết cho fragment này

        return view
    }
}
