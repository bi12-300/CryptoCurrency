package com.example.cryptocurrency.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrency.R
import com.google.android.material.button.MaterialButton

class PaymentMethodFragment : Fragment() {

    private lateinit var bankAccountsRecyclerView: RecyclerView
    private lateinit var addCreditCardButton: MaterialButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.payment_method, container, false)

        // Initialize RecyclerView
        bankAccountsRecyclerView = view.findViewById(R.id.recycler_view_bank_accounts)
        bankAccountsRecyclerView.layoutManager = LinearLayoutManager(context)

        // Adapter for displaying bank accounts (implement this with real data)
        val bankAccountAdapter = BankAccountAdapter(listOf("Account 1", "Account 2", "Account 3"))
        bankAccountsRecyclerView.adapter = bankAccountAdapter

        // Set up button to add a new credit card
        addCreditCardButton = view.findViewById(R.id.button_add_credit_card)
        addCreditCardButton.setOnClickListener {
            Toast.makeText(context, "Thêm thẻ tín dụng mới", Toast.LENGTH_SHORT).show()
            // Code to navigate to AddCreditCardFragment can go here
        }

        return view
    }
}
