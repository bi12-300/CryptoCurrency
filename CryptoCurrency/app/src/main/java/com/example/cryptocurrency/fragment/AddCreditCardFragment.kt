package com.example.cryptocurrency.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.cryptocurrency.R

class AddCreditCardFragment : Fragment() {

    private lateinit var firstNameEditText: EditText
    private lateinit var lastNameEditText: EditText
    private lateinit var cardNumberEditText: EditText
    private lateinit var expiryDateEditText: EditText
    private lateinit var cvvEditText: EditText
    private lateinit var streetAddressEditText: EditText
    private lateinit var postalCodeEditText: EditText
    private lateinit var cityEditText: EditText
    private lateinit var countryEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_add_credit_card, container, false)

        // Initialize EditTexts
        firstNameEditText = view.findViewById(R.id.editText_first_name)
        lastNameEditText = view.findViewById(R.id.editText_last_name)
        cardNumberEditText = view.findViewById(R.id.editText_card_number)
        expiryDateEditText = view.findViewById(R.id.editText_expiry_date)
        cvvEditText = view.findViewById(R.id.editText_cvv)
        streetAddressEditText = view.findViewById(R.id.editText_street_address)
        postalCodeEditText = view.findViewById(R.id.editText_postal_code)
        cityEditText = view.findViewById(R.id.editText_city)
        countryEditText = view.findViewById(R.id.editText_country)

        // Set button listeners
        view.findViewById<View>(R.id.button_save_card).setOnClickListener { saveCard() }
        view.findViewById<View>(R.id.button_autofill_address).setOnClickListener { autofillAddress() }

        return view
    }

    private fun saveCard() {
        // Validate input
        val firstName = firstNameEditText.text.toString().trim()
        val lastName = lastNameEditText.text.toString().trim()
        val cardNumber = cardNumberEditText.text.toString().trim()
        val expiryDate = expiryDateEditText.text.toString().trim()
        val cvv = cvvEditText.text.toString().trim()

        if (firstName.isEmpty() || lastName.isEmpty()) {
            showToast("Vui lòng nhập họ tên.")
            return
        }

        if (cardNumber.length != 16 || !cardNumber.all { it.isDigit() }) {
            showToast("Số thẻ không hợp lệ.")
            return
        }

        if (!expiryDate.matches(Regex("^(0[1-9]|1[0-2])/[0-9]{2}\$"))) {
            showToast("Ngày hết hạn không hợp lệ. Định dạng: MM/YY")
            return
        }

        if (cvv.length != 3 || !cvv.all { it.isDigit() }) {
            showToast("CVV phải có 3 chữ số.")
            return
        }

        showToast("Thẻ đã được lưu thành công!")
        // Add save logic here
    }

    private fun autofillAddress() {
        // Simple autofill example
        streetAddressEditText.setText("123 Nguyễn Thị Minh Khai")
        postalCodeEditText.setText("700000")
        cityEditText.setText("TP. Hồ Chí Minh")
        countryEditText.setText("Việt Nam")

        showToast("Đã tự động điền địa chỉ!")
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}
