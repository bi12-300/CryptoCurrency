package com.example.cryptocurrency.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.cryptocurrency.R

class PaymentMethodFragment : Fragment() {
    private lateinit var buttonAddCreditCard: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.payment_method, container, false)

        // Initialize the button
        buttonAddCreditCard = view.findViewById(R.id.button_add_credit_card)

        // Set click listener for the button
        buttonAddCreditCard.setOnClickListener {
            // Start the AddCreditCardActivity
            val intent = Intent(activity, AddCreditCardFragment::class.java)
            startActivity(intent)
        }

        return view
    }
}
