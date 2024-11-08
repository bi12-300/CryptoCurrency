package com.example.cryptocurrency.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.cryptocurrency.R

class SearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.search, container, false)

        // Gán các thành phần
        val backButton = view.findViewById<ImageView>(R.id.back_button) // Đảm bảo ID này là ImageView
        val searchInput = view.findViewById<EditText>(R.id.search_edit_text)

        // Xử lý sự kiện
        backButton.setOnClickListener {
            requireActivity().onBackPressed() // Quay lại màn hình trước đó
        }

        return view
    }
}
