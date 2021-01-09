package com.example.transferencias

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.Observer
import com.example.transferencias.Client.ClientViewModel
import kotlinx.android.synthetic.main.activity_payment.*

class PagosActivity : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProviders.of(this)[ClientViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel.getCustomer();
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        addPaymentButton.setOnClickListener { addPayments() }
        addObserver()
    }
    private fun addObserver() {
            viewModel.message.observe(this, Observer {
                val toast = Toast.makeText(applicationContext, "Registro exitoso", Toast.LENGTH_LONG)
                toast.show()
            })
        viewModel.customer.observe(this, Observer {
            paymentsSpinner.adapter = SpinnerAdapter(this, android.R.layout.simple_spinner_dropdown_item, it.toCollection(ArrayList()))

        })
    }
    private fun addPayments() {
        val idCustomer = (paymentsSpinner.selectedItem as Customer).idCustomer
        val registerDate = " "
        val date = dateEditText.text.toString()
        val amount = amounEditText.text.toString()
        val payment = Payments(
            idCustomer,
            registerDate,
            date,
            amount
        )
        if (date != "" && amount != "")
            viewModel.sendPayment(payment)
        else{
            val toast = Toast.makeText(applicationContext, "No dejar campos vacios", Toast.LENGTH_LONG)
            toast.show()
        }
    }
}