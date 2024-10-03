package com.example.cryptocurrency.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.cryptocurrency.R

class AddCreditCardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.activity_add_credit_card, container, false)

        // Ánh xạ các EditText
        val firstNameEditText = view.findViewById<EditText>(R.id.editText_first_name)
        val lastNameEditText = view.findViewById<EditText>(R.id.editText_last_name)
        val cardNumberEditText = view.findViewById<EditText>(R.id.editText_card_number)
        val expiryDateEditText = view.findViewById<EditText>(R.id.editText_expiry_date)
        val cvvEditText = view.findViewById<EditText>(R.id.editText_cvv)

        // Ánh xạ nút xác nhận
        val saveCardButton = view.findViewById<Button>(R.id.button_save_card)
        saveCardButton.setOnClickListener {
            // Thực hiện xác nhận thông tin thẻ
            if (validateInputs(firstNameEditText, lastNameEditText, cardNumberEditText, expiryDateEditText, cvvEditText)) {
                // Xử lý thêm thẻ tín dụng ở đây
                Toast.makeText(context, "Thẻ tín dụng đã được thêm!", Toast.LENGTH_SHORT).show()
                // Điều hướng trở lại fragment trước đó hoặc đến fragment khác nếu cần
                // findNavController().navigate(R.id.action_addCreditCardFragment_to_someOtherFragment)
            }
        }

        return view
    }

    // Hàm kiểm tra thông tin đầu vào
    private fun validateInputs(vararg fields: EditText): Boolean {
        for (field in fields) {
            if (field.text.isEmpty()) {
                field.error = "Trường này không thể để trống"
                return false
            }
        }
        return true
    }
}
