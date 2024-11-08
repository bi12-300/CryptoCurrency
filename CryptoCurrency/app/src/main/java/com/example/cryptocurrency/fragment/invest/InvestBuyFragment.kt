package com.example.cryptocurrency.fragment.invest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.cryptocurrency.R

class InvestBuyFragment : Fragment() {

    private lateinit var editTextAmount: EditText
    private lateinit var spinnerCurrency: Spinner
    private lateinit var conversionResult: TextView
    private lateinit var buyButton: Button
    private lateinit var payment: Button // Thêm buttonInvest

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.invest_buy, container, false)

        // Ánh xạ các thành phần giao diện
        editTextAmount = view.findViewById(R.id.editText_amount)
        spinnerCurrency = view.findViewById(R.id.spinner_currency)
        conversionResult = view.findViewById(R.id.conversion_result)
        buyButton = view.findViewById(R.id.button_buy_coin) // Đảm bảo ID này đúng
        payment = view.findViewById(R.id.button_select_payment_method) // Thêm dòng này

        // Gắn sự kiện cho nút "Buy"
        buyButton.setOnClickListener {
            val amountStr = editTextAmount.text.toString()
            val selectedCurrency = spinnerCurrency.selectedItem.toString()

            if (amountStr.isNotEmpty()) {
                val amount = amountStr.toDouble()
                val conversionRate = getConversionRate(selectedCurrency)
                val resultInCrypto = amount / conversionRate

                // Hiển thị kết quả quy đổi
                conversionResult.text = String.format("%.4f BTC", resultInCrypto)
            }
        }

        // Gắn sự kiện cho buttonInvest để chuyển sang AddCreditCardFragment
        payment.setOnClickListener {
            val fragment = AddCreditCardFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment) // ID của container layout trong MainActivity
                .addToBackStack(null)
                .commit()
        }

        return view
    }

    // Hàm lấy tỷ giá quy đổi tiền tệ
    private fun getConversionRate(currency: String): Double {
        return when (currency) {
            "VND" -> 23000.0  // Ví dụ tỷ giá VND
            "MNT" -> 3400.0   // Ví dụ tỷ giá MNT
            "ERN" -> 15.0     // Ví dụ tỷ giá ERN
            else -> 1.0
        }
    }
}
